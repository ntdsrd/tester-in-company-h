package test;

import action.json.CreateBookingJSON;
import action.json.GetBookingJSON;
import action.common.GlobalConstant;
import action.json.UpdateBookingJSON;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RequestJSON {
    public CreateBookingJSON createBookingJSON = new CreateBookingJSON();
    public GetBookingJSON getBookingJSON = new GetBookingJSON();
    public UpdateBookingJSON updateBookingJSON = new UpdateBookingJSON();

    @AfterTest
    public void AfterTest() {
        GlobalConstant.softAssert.assertAll();
    }

    @Test(description = "POST: CreateBookingJSON")
    public void CreateBookingJSON() {
        //post request
        System.out.println("POST:");
        createBookingJSON.PostRequest();
        //validate status code
        System.out.println("Validate Status Code:");
        createBookingJSON.ValidateStatusCode(GlobalConstant.STATUS_CODE_OK);
        //get booking id
        System.out.println("Booking ID:");
        createBookingJSON.GetBookingId();
        //validation for api schema
        System.out.println("Validation For API Schema:");
        createBookingJSON.ValidationForAPISchema();
    }

    @Test(description = "GET: GetBookingJSON", dependsOnMethods = {"CreateBookingJSON"})
    public void GetBookingJSON() {
        //get request
        System.out.println("GET:");
        getBookingJSON.GetRequest();
        //validate firstname
        System.out.println("Validate First Name:");
        getBookingJSON.ValidateFirstName(GlobalConstant.FIRSTNAME);
        //validate lastname
        System.out.println("Validate Last Name:");
        getBookingJSON.ValidateLastName(GlobalConstant.LASTNAME);
    }

    @Test(description = "PUT: UpdateBookingJSON", dependsOnMethods = {"GetBookingJSON"})
    public void UpdateBookingJSON() {
        //put request
        System.out.println("PUT:");
        updateBookingJSON.PutRequest();
        //validate information as needs
        System.out.println("Validate Information As Needs:");
        updateBookingJSON.ValidateInformationAsNeeds(GlobalConstant.ADDITIONAL_NEEDS);
    }
}