package action.json;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetBookingJSON {
    public HttpResponse<String> response;
    public JSONObject jsonObject;

    public void GetRequest() {
        Unirest.setTimeouts(0, 0);
        try {
            response = Unirest.get(GlobalConstant.URL.concat(CreateBookingJSON.bookingId)).header("Accept", GlobalConstant.JSON).asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody());
    }

    public void ValidateFirstName(String firstName) {
        jsonObject = new JSONObject(response.getBody());
        if (jsonObject.get("firstname").equals(firstName)) {
            System.out.println("First name is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.get("firstname"), firstName);
        }
    }

    public void ValidateLastName(String lastName) {
        jsonObject = new JSONObject(response.getBody());
        if (jsonObject.get("lastname").equals(lastName)) {
            System.out.println("Last name is correct");
        } else {
            GlobalConstant.softAssert.assertEquals(jsonObject.get("lastname"), lastName);
        }
    }
}