// SaxThroughJaxp.java

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxThroughJaxp 
{

    public void parse( String fileName )throws FactoryConfigurationError,ParserConfigurationException, SAXException, IOException {

    	
        // Get SAX Parser Factory

        SAXParserFactory factory =SAXParserFactory.newInstance();

        // set configuration options

        factory.setValidating( true );
        factory.setNamespaceAware( true );

        // the configuration options must be set before invoking newSAXParser() method

        SAXParser parser = factory.newSAXParser();

        // parse the XML document

        parser.parse( new File("emp-2.xml" ), new SampleHandler() );

/*

try 
		{
			SAXParser saxParser=saxFact.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(new IGateHandler());
			xmlReader.parse("projectList.xml");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}

*/
    }

    public static void main( String[] args )throws FactoryConfigurationError, ParserConfigurationException, SAXException, IOException 
                {

        SaxThroughJaxp sax = new SaxThroughJaxp();

        String fileName = "order.xml";

        sax.parse( fileName );
    }
}

