import action.common.GlobalConstant;
import action.json.CreateBookingJSON;
import action.json.GetBookingJSON;
import action.json.UpdateBookingJSON;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RequestJSON {
    public CreateBookingJSON createBookingJSON = new CreateBookingJSON();
    public GetBookingJSON getBookingJSON = new GetBookingJSON();
    public UpdateBookingJSON updateBookingJSON = new UpdateBookingJSON();

    @AfterTest(alwaysRun = true, groups = {"DevInt", "PreProd", "Prod"})
    public void AfterTest() {
        GlobalConstant.softAssert.assertAll();
    }

    @Parameters({"url", "firstname", "lastname", "totalprice", "depositpaid", "checkin", "checkout", "additionalneeds"})
    @Test(description = "POST: CreateBookingJSON", groups = {"DevInt", "PreProd", "Prod"})
    public void CreateBookingJSON(String url, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        //post request
        System.out.print("POST: ");
        createBookingJSON.PostRequest(url, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
        //validate status code
        System.out.print("VALIDATE STATUS CODE: ");
        createBookingJSON.ValidateStatusCode(GlobalConstant.STATUS_CODE_OK);
        //get booking id
        System.out.print("BOOKING ID: ");
        createBookingJSON.GetBookingId();
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        createBookingJSON.ValidationForAPISchema();
        System.out.println();
    }

    @Parameters({"url"})
    @Test(description = "GET: GetBookingJSON", dependsOnMethods = {"CreateBookingJSON"}, groups = {"DevInt", "Prod"})
    public void GetBookingJSON(String url) {
        //get request
        System.out.print("GET: ");
        getBookingJSON.GetRequest(url);
        //validate firstname
        System.out.print("VALIDATE FIRST NAME: ");
        getBookingJSON.ValidateFirstName(GlobalConstant.FIRSTNAME);
        //validate lastname
        System.out.print("VALIDATE LAST NAME: ");
        getBookingJSON.ValidateLastName(GlobalConstant.LASTNAME);
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        getBookingJSON.ValidationForAPISchema();
        System.out.println();
    }

    @Parameters({"url", "auth", "firstname", "lastname", "totalprice", "depositpaid", "checkin", "checkout", "additionalneeds_update"})
    @Test(description = "PUT: UpdateBookingJSON", dependsOnMethods = {"CreateBookingJSON"}, groups = {"PreProd", "Prod"})
    public void UpdateBookingJSON(String url, String auth, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds_update) {
        //put request
        System.out.print("PUT: ");
        updateBookingJSON.PutRequest(url, auth, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds_update);
        //validate information as needs
        System.out.print("VALIDATE INFORMATION AS NEEDS: ");
        updateBookingJSON.ValidateInformationAsNeeds(GlobalConstant.ADDITIONAL_NEEDS);
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        updateBookingJSON.ValidationForAPISchema();
        System.out.println();
    }
}