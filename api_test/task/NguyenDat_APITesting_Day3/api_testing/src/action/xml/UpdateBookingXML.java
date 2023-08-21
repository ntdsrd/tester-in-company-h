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

public class UpdateBookingXML {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public String xml;

    public void PutRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            xml = new String(Files.readAllBytes(Paths.get(GlobalConstant.RESOURCE_PATH.concat("booking_update.xml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            response = Unirest.post(GlobalConstant.URL).header("Authorization", GlobalConstant.AUTH).header("Content-Type", GlobalConstant.XML_REQUEST).header("Accept", GlobalConstant.XML_RESPONSE).body(xml).asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody());
    }

    public void ValidateInformationAsNeeds(String additionalNeeds) {
        jsonObject = XML.toJSONObject(response.getBody());
        if (jsonObject.getJSONObject("created-booking").getJSONObject("booking").get("additionalneeds").equals(additionalNeeds)) {
            System.out.println("Additional Needs is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("created-booking").getJSONObject("booking").get("additionalneeds"), additionalNeeds);
        }
    }
}
