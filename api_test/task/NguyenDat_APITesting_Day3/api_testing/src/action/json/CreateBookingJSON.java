package action.json;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public String json;
    public static String bookingId;

    public void PostRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            json = new String(Files.readAllBytes(Paths.get(GlobalConstant.RESOURCE_PATH.concat("booking.json"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            response = Unirest.post(GlobalConstant.URL).header("Content-Type", GlobalConstant.JSON).header("Accept", GlobalConstant.JSON).body(json).asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody());
    }

    public void ValidateStatusCode(int status) {
        if (response.getStatus() == status) {
            System.out.println("Status code is " + response.getStatus() + " " + response.getStatusText());
        } else {
            GlobalConstant.softAssert.assertEquals(response.getStatus(), status);
        }
    }

    public void GetBookingId() {
        jsonObject = new JSONObject(response.getBody());
        bookingId = jsonObject.get("bookingid").toString();
        System.out.println(bookingId);
    }

    public void ValidationForAPISchema() {
    }
}