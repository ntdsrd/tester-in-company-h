package action.xml;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateBookingXML {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public String xml;
    public static String bookingId;

    public void PostRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            xml = new String(Files.readAllBytes(Paths.get(GlobalConstant.RESOURCE_PATH.concat("booking.xml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            response = Unirest.post(GlobalConstant.URL).header("Content-Type", GlobalConstant.XML_REQUEST).header("Accept", GlobalConstant.XML_RESPONSE).body(xml).asString();
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
        jsonObject = XML.toJSONObject(response.getBody());
        bookingId = jsonObject.getJSONObject("created-booking").get("bookingid").toString();
        System.out.println(bookingId);
    }
}
