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

public class CreateBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public Schema schema;
    public String json;
    public String jsonSchema;
    public static String bookingId;

    public void PostRequest(String url, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
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
                "  \"additionalneeds\": \"" + additionalneeds + "\"\n" +
                "}";
        try {
            response = Unirest.post(url).header("Content-Type", GlobalConstant.JSON).header("Accept", GlobalConstant.JSON).body(json).asString();
            System.out.println(response.getBody());
            jsonObject = new JSONObject(response.getBody());
        } catch (UnirestException e) {
            System.out.println("Send POST request fail");
            throw new RuntimeException(e);
        }
    }

    public void ValidateStatusCode(int status) {
        if (response.getStatus() == status) {
            System.out.println("Status code is " + response.getStatus() + " " + response.getStatusText());
        } else {
            System.out.println("Validate status code fail");
            GlobalConstant.softAssert.assertEquals(response.getStatus(), status);
        }
    }

    public void GetBookingId() {
        try {
            bookingId = jsonObject.get("bookingid").toString();
            System.out.println(bookingId);
        } catch (Exception e) {
            System.out.println("Get booking id fail");
        }
    }

    public void ValidationForAPISchema() {
        try {
            jsonSchema = new String(Files.readAllBytes(Paths.get(GlobalConstant.FILE_JSON.concat("post.schema.json"))));
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