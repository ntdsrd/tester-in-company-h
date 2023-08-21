import action.common.GlobalConstant;
import action.xml.CreateBookingXML;
import action.xml.GetBookingXML;
import action.xml.UpdateBookingXML;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RequestXML {
    public CreateBookingXML createBookingXML = new CreateBookingXML();
    public GetBookingXML getBookingXML = new GetBookingXML();
    public UpdateBookingXML updateBookingXML = new UpdateBookingXML();

    @AfterTest(alwaysRun = true, groups = {"DevInt", "PreProd", "Prod"})
    public void AfterTest() {
        GlobalConstant.softAssert.assertAll();
    }

    @Parameters({"url", "firstname", "lastname", "totalprice", "depositpaid", "checkin", "checkout", "additionalneeds"})
    @Test(description = "POST: CreateBookingXML", groups = {"DevInt", "PreProd", "Prod"})
    public void CreateBookingXML(String url, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        //post request
        System.out.print("POST: ");
        createBookingXML.PostRequest(url, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
        //validate status code
        System.out.print("VALIDATE STATUS CODE: ");
        createBookingXML.ValidateStatusCode(GlobalConstant.STATUS_CODE_OK);
        //get booking id
        System.out.print("GET BOOKING ID: ");
        createBookingXML.GetBookingId();
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        createBookingXML.ValidationForAPISchema();
        System.out.println();
    }

    @Parameters({"url"})
    @Test(description = "GET: GetBookingXML", dependsOnMethods = {"CreateBookingXML"}, groups = {"PreProd", "Prod"})
    public void GetBookingXML(String url) {
        //get request
        System.out.print("GET: ");
        getBookingXML.GetRequest(url);
        //validate firstname
        System.out.print("VALIDATE FIRST NAME: ");
        getBookingXML.ValidateFirstName(GlobalConstant.FIRSTNAME);
        //validate lastname
        System.out.print("VALIDATE LAST NAME: ");
        getBookingXML.ValidateLastName(GlobalConstant.LASTNAME);
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        getBookingXML.ValidationForAPISchema();
        System.out.println();
    }

    @Parameters({"url", "auth", "firstname", "lastname", "totalprice", "depositpaid", "checkin", "checkout", "additionalneeds_update"})
    @Test(description = "PUT: UpdateBookingXML", dependsOnMethods = {"CreateBookingXML"}, groups = {"DevInt", "Prod"})
    public void UpdateBookingXML(String url, String auth, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds_update) {
        //put request
        System.out.print("PUT: ");
        updateBookingXML.PutRequest(url, auth, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds_update);
        //validate information as needs
        System.out.print("VALIDATE INFORMATION AS NEEDS: ");
        updateBookingXML.ValidateInformationAsNeeds(GlobalConstant.ADDITIONAL_NEEDS);
        //validation for api schema
        System.out.print("VALIDATION FOR API SCHEMA: ");
        updateBookingXML.ValidationForAPISchema();
        System.out.println();
    }
}