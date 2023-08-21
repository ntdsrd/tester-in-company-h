package action.json;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UpdateBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public String json;

    public void PutRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            json = new String(Files.readAllBytes(Paths.get(GlobalConstant.RESOURCE_PATH.concat("booking_update.json"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            response = Unirest.post(GlobalConstant.URL).header("Authorization", GlobalConstant.AUTH).header("Content-Type", GlobalConstant.JSON).header("Accept", GlobalConstant.JSON).body(json).asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody());
    }

    public void ValidateInformationAsNeeds(String additionalNeeds) {
        jsonObject = new JSONObject(response.getBody());
        if (jsonObject.getJSONObject("booking").get("additionalneeds").equals(additionalNeeds)) {
            System.out.println("Additional Needs is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("booking").get("additionalneeds"), additionalNeeds);
        }
    }
}
