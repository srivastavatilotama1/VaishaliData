
/**
 * @author vivek
 * 
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomParsing {

	public static void main(String args[]) 
	{
		try 
		{

			// Get Document Builder Factory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Leave off validation, and turn off namespaces
			factory.setValidating(false);
			factory.setNamespaceAware(false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("dbxml.xml"));

			// Print the document from the DOM tree and
			// feed it an initial indentation of nothing
			printNode(doc, "");

		}
		catch (ParserConfigurationException e) 
		{
			System.out.println("The underlying parser does not support the requested features.");
		} 
		catch (FactoryConfigurationError e) 
		{
			System.out.println("Error occurred obtaining Document Builder Factory.");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void printNode(Node node, String indent) 
	{
		switch (node.getNodeType()) 
		{

		case Node.DOCUMENT_NODE:
			// recurse on each child
			NodeList nodes = node.getChildNodes();
			if (nodes != null) 
			{
				for (int i = 0; i < nodes.getLength(); i++) 
				{
					printNode(nodes.item(i), "");
				}
			}
			break;

		case Node.ELEMENT_NODE:
			String name = node.getNodeName();
			System.out.print(indent + "<" + name);
			NamedNodeMap attributes = node.getAttributes();
			for (int i = 0; i < attributes.getLength(); i++) 
			{
				Node current = attributes.item(i);
				System.out.print(" " + current.getNodeName() + "=\""+ current.getNodeValue() + "\"");
			}
			System.out.print(">");

			// recurse on each child
			NodeList children = node.getChildNodes();
			if (children != null) 
			{
				for (int i = 0; i < children.getLength(); i++) 
				{
					printNode(children.item(i), indent + "  ");
				}
			}
			
			System.out.println("</" + name + ">");
			break;

		case Node.TEXT_NODE:
			System.out.print(node.getNodeValue());
			break;
		}

	}

}
