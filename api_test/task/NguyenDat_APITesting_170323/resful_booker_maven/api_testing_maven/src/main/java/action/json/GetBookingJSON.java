package action.json;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public Schema schema;
    public String jsonSchema;

    public void GetRequest(String url) {
        Unirest.setTimeouts(0, 0);
        try {
            response = Unirest.get(url.concat(CreateBookingJSON.bookingId)).header("Accept", GlobalConstant.JSON).asString();
            System.out.println(response.getBody());
            jsonObject = new JSONObject(response.getBody());
        } catch (UnirestException e) {
            System.out.println("Send GET request fail");
            throw new RuntimeException(e);
        }
    }

    public void ValidateFirstName(String firstName) {
        if (jsonObject.get("firstname").equals(firstName)) {
            System.out.println("First name is correct");
        } else {
            System.out.println("Validate first name fail");
            GlobalConstant.softAssert.assertEquals(jsonObject.get("firstname"), firstName);
        }
    }

    public void ValidateLastName(String lastName) {
        if (jsonObject.get("lastname").equals(lastName)) {
            System.out.println("Last name is correct");
        } else {
            System.out.println("Validate last name fail");
            GlobalConstant.softAssert.assertEquals(jsonObject.get("lastname"), lastName);
        }
    }

    public void ValidationForAPISchema() {
        try {
            jsonSchema = new String(Files.readAllBytes(Paths.get(GlobalConstant.FILE_JSON.concat("get.schema.json"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject rawSchema = new JSONObject(new JSONTokener(jsonSchema));
        schema = SchemaLoader.load(rawSchema);
        try {
            schema.validate(new JSONObject(jsonObject.toString()));
            System.out.println("Schema is valid");
        } catch (ValidationException validationException) {
            System.out.println("Schema is invalid");
            validationException.printStackTrace();
        }
    }
}