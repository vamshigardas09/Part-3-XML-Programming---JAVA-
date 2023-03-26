import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {
    public static void main(String[] args) {
        try {
            String xmlFilePath = "F:\\assignment3\\restaurant.xml";

            // Initialize the document builder factory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Set error handler for validation errors
            documentBuilder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException e) throws SAXException {
                    System.err.println("Warning: " + e.getMessage());
                }

                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.err.println("Error: " + e.getMessage());
                }

                @Override
                public void fatalError(SAXParseException e) throws SAXException {
                    System.err.println("Fatal error: " + e.getMessage());
                }
            });

            // Parse the XML file
            Document document = documentBuilder.parse(new File(xmlFilePath));

            // If the parsing is successful, print the success message
            System.out.println("XML document is valid against the DTD!");

        } catch (SAXException e) {
            System.err.println("DTD validation error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
