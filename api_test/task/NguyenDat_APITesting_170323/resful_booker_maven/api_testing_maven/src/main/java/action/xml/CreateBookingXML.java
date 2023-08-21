package action.xml;

import action.common.GlobalConstant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateBookingXML {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public SchemaFactory factory;
    public Schema schema;
    public Validator validator;
    public String xml;
    public String xmlSchema;
    public String xmlResponse;
    public static String bookingId;

    public void PostRequest(String url, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        Unirest.setTimeouts(0, 0);
        xml = "<booking>\n" +
                "    <firstname>" + firstname + "</firstname>\n" +
                "    <lastname>" + lastname + "</lastname>\n" +
                "    <totalprice>" + totalprice + "</totalprice>\n" +
                "    <depositpaid>" + depositpaid + "</depositpaid>\n" +
                "    <bookingdates>\n" +
                "        <checkin>" + checkin + "</checkin>\n" +
                "        <checkout>" + checkout + "</checkout>\n" +
                "    </bookingdates>\n" +
                "    <additionalneeds>" + additionalneeds + "</additionalneeds>\n" +
                "</booking>";
        try {
            response = Unirest.post(url).header("Content-Type", GlobalConstant.XML_REQUEST).header("Accept", GlobalConstant.XML_RESPONSE).body(xml).asString();
            System.out.println(response.getBody());
            jsonObject = XML.toJSONObject(response.getBody());
        } catch (UnirestException e) {
            System.out.println("Send POST request fail");
            throw new RuntimeException(e);
        }
    }

    public void ValidateStatusCode(int status) {
        if (response.getStatus() == status) {
            System.out.println("Status code is " + response.getStatus() + " " + response.getStatusText());
        } else {
            System.out.println("Validate status code fail");
            GlobalConstant.softAssert.assertEquals(response.getStatus(), status);
        }
    }

    public void GetBookingId() {
        try {
            bookingId = jsonObject.getJSONObject("created-booking").get("bookingid").toString();
            System.out.println(bookingId);
        } catch (Exception e) {
            System.out.println("Get booking id fail");
        }
    }

    public void ValidationForAPISchema() {
        Path path = Paths.get(GlobalConstant.FILE_XML.concat("response.xml"));
        try {
            Files.createFile(path);
            Files.write(path, response.getBody().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        xmlSchema = GlobalConstant.FILE_XML.concat("post_schema.xsd");
        xmlResponse = GlobalConstant.FILE_XML.concat("response.xml");
        factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schema = factory.newSchema(new File(xmlSchema));
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        validator = schema.newValidator();
        try {
            validator.validate(new StreamSource(xmlResponse));
            System.out.println("Schema is valid");
        } catch (SAXException | IOException e) {
            System.out.println("Schema is invalid");
            throw new RuntimeException(e);
        }
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}