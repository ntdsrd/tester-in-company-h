package test;

import action.common.GlobalConstant;
import action.xml.CreateBookingXML;
import action.xml.GetBookingXML;
import action.xml.UpdateBookingXML;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RequestXML {
    public CreateBookingXML createBookingXML = new CreateBookingXML();
    public GetBookingXML getBookingXML = new GetBookingXML();
    public UpdateBookingXML updateBookingXML = new UpdateBookingXML();

    @AfterTest
    public void AfterTest() {
        GlobalConstant.softAssert.assertAll();
    }

    @Test(description = "POST: CreateBookingXML")
    public void CreateBookingXML() {
        //post request
        System.out.println("POST:");
        createBookingXML.PostRequest();
        //validate status code
        System.out.println("Validate Status Code:");
        createBookingXML.ValidateStatusCode(GlobalConstant.STATUS_CODE_OK);
        //get booking id
        System.out.println("Booking ID:");
        createBookingXML.GetBookingId();
    }

    @Test(description = "GET: GetBookingXML", dependsOnMethods = {"CreateBookingXML"})
    public void GetBookingXML() {
        //get request
        System.out.println("GET:");
        getBookingXML.GetRequest();
        //validate firstname
        System.out.println("Validate First Name:");
        getBookingXML.ValidateFirstName(GlobalConstant.FIRSTNAME);
        //validate lastname
        System.out.println("Validate Last Name:");
        getBookingXML.ValidateLastName(GlobalConstant.LASTNAME);
    }

    @Test(description = "PUT: UpdateBookingXML", dependsOnMethods = {"GetBookingXML"})
    public void UpdateBookingXML() {
        //put request
        System.out.println("PUT:");
        updateBookingXML.PutRequest();
        //validate information as needs
        System.out.println("Validate Information As Needs:");
        updateBookingXML.ValidateInformationAsNeeds(GlobalConstant.ADDITIONAL_NEEDS);
    }
}
