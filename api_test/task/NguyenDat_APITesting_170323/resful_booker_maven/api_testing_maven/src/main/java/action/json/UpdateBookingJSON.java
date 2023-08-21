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

public class UpdateBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public Schema schema;
    public String json;
    public String jsonSchema;

    public void PutRequest(String url, String auth, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds_update) {
        Unirest.setTimeouts(0, 0);
        json = "{\n" +
                "  \"firstname\": \"" + firstname + "\",\n" +
                "  \"lastname\": \"" + lastname + "\",\n" +
                "  \"totalprice\": \"" + totalprice + "\",\n" +
                "  \"depositpaid\": " + depositpaid + ",\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"" + checkin + "\",\n" +
                "    \"checkout\": \"" + checkout + "\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"" + additionalneeds_update + "\"\n" +
                "}";
        try {
            response = Unirest.put(url.concat(CreateBookingJSON.bookingId)).header("Authorization", auth).header("Content-Type", GlobalConstant.JSON).header("Accept", GlobalConstant.JSON).body(json).asString();
            System.out.println(response.getBody());
            jsonObject = new JSONObject(response.getBody());
        } catch (UnirestException e) {
            System.out.println("Send PUT request fail");
            throw new RuntimeException(e);
        }
    }

    public void ValidateInformationAsNeeds(String additionalNeeds) {
        if (jsonObject.get("additionalneeds").equals(additionalNeeds)) {
            System.out.println("Additional Needs is correct");
        } else {
            System.out.println("Validate additional needs fail");
            GlobalConstant.softAssert.assertEquals(jsonObject.get("additionalneeds"), additionalNeeds);
        }
    }

    public void ValidationForAPISchema() {
        try {
            jsonSchema = new String(Files.readAllBytes(Paths.get(GlobalConstant.FILE_JSON.concat("put.schema.json"))));
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