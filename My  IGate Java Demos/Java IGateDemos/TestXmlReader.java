import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
public class TestXmlReader {


	public static void main(String[] args) 
	{
		SAXParserFactory saxFact=SAXParserFactory.newInstance();

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


	}

}
