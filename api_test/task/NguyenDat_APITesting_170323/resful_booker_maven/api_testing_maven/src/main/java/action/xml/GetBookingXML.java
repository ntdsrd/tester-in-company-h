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

public class GetBookingXML {
    public HttpResponse<String> response;
    public JSONObject jsonObject;
    public SchemaFactory factory;
    public Schema schema;
    public Validator validator;
    public String xmlSchema;
    public String xmlResponse;

    public void GetRequest(String url) {
        Unirest.setTimeouts(0, 0);
        try {
            response = Unirest.get(url.concat(CreateBookingXML.bookingId)).header("Accept", GlobalConstant.XML_RESPONSE).asString();
            System.out.println(response.getBody());
            jsonObject = XML.toJSONObject(response.getBody());
        } catch (UnirestException e) {
            System.out.println("Send GET request fail");
            throw new RuntimeException(e);
        }
    }

    public void ValidateFirstName(String firstName) {
        if (jsonObject.getJSONObject("booking").get("firstname").equals(firstName)) {
            System.out.println("First name is correct");
        } else {
            System.out.println("Validate first name fail");
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("booking").get("firstname"), firstName);
        }
    }

    public void ValidateLastName(String lastName) {
        if (jsonObject.getJSONObject("booking").get("lastname").equals(lastName)) {
            System.out.println("Last name is correct");
        } else {
            System.out.println("Validate last name fail");
            GlobalConstant.softAssert.assertEquals(jsonObject.getJSONObject("booking").get("lastname"), lastName);
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
        xmlSchema = GlobalConstant.FILE_XML.concat("get_schema.xsd");
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