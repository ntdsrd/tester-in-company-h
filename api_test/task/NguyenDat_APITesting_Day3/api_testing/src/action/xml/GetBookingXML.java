package action.xml;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.XML;

public class GetBookingXML {
    public HttpResponse<String> response;
    public JSONObject jsonObject;

    public void GetRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            response = Unirest.get(GlobalConstant.URL.concat(CreateBookingXML.bookingId)).header("Accept", GlobalConstant.XML_RESPONSE).asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody());
    }

    public void ValidateFirstName(String firstName) {
        jsonObject = XML.toJSONObject(response.getBody());
        if (jsonObject.getJSONObject("booking").get("firstname").equals(firstName)) {
            System.out.println("First name is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("booking").get("firstname"), firstName);
        }
    }

    public void ValidateLastName(String lastName) {
        if (jsonObject.getJSONObject("booking").get("lastname").equals(lastName)) {
            System.out.println("Last name is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("booking").get("lastname"), lastName);
        }
    }
}
