/**
 * @author vivek
 * 
 */

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class XMLValidation
{
	public static void main(String[] args) 
	{
		try 
		{
            // Parse an XML document into a DOM tree.
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parser.parse(new File("musicians.xml"));

            // Create a SchemaFactory capable of understanding WXS schemas.
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load a WXS schema, represented by a Schema instance.
            Source schemaFile = new StreamSource(new File("musician.xsd"));
            Schema schema = factory.newSchema(schemaFile);

            // Create a Validator object, which can be used to validate an instance document.
            Validator validator = schema.newValidator();

            // Validate the DOM tree
            validator.validate(new DOMSource(document));
            
            System.out.println("XML file is valid!!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);            
        } catch (SAXException e) {
        	e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }       
	}
}
