import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomParserSchema {
    public static void main(String[] args) {
        try {
            String xmlFilePath = "F:\\assignment3\\restaurant.xml";
            String schemaFilePath = "F:\\assignment3\\restaurant.xsd";

            // Initialize the schema factory
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(schemaFilePath));

            // Initialize the document builder factory and set the schema
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setSchema(schema);
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Parse the XML file
            Document document = documentBuilder.parse(new File(xmlFilePath));

            // If the parsing is successful, print the success message
            System.out.println("XML document is valid against the schema!");

        } catch (SAXException e) {
            System.err.println("Schema validation error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}