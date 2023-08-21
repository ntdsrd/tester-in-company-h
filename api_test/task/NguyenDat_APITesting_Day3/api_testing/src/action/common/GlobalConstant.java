package action.common;

import org.testng.asserts.SoftAssert;

public class GlobalConstant {
    public static SoftAssert softAssert = new SoftAssert();
    public static final String URL = "https://restful-booker.herokuapp.com/booking/";
    public static final String AUTH = "Basic YWRtaW46cGFzc3dvcmQxMjM=";
    public static final String JSON = "application/json";
    public static final String XML_REQUEST = "text/xml";
    public static final String XML_RESPONSE = "application/xml";
    public static final String RESOURCE_PATH = "C:\\Users\\nguyen.dat\\IdeaProjects\\api_testing\\src\\file\\";
    public static final int STATUS_CODE_OK = 200;
    public static final String FIRSTNAME = "dat";
    public static final String LASTNAME = "nguyen";
    public static final String ADDITIONAL_NEEDS = "trada";
}
