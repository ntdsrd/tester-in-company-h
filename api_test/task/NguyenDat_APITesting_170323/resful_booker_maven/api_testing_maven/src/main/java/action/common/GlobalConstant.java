package action.common;

import org.testng.asserts.SoftAssert;

public class GlobalConstant {
    public static SoftAssert softAssert = new SoftAssert();
    public static final String JSON = "application/json";
    public static final String XML_REQUEST = "text/xml";
    public static final String XML_RESPONSE = "application/xml";
    public static final String FILE_JSON = "src/main/resources/json/";
    public static final String FILE_XML = "src/main/resources/xml/";
    public static final int STATUS_CODE_OK = 200;
    public static final String FIRSTNAME = "dat";
    public static final String LASTNAME = "nguyen";
    public static final String ADDITIONAL_NEEDS = "trada";
}