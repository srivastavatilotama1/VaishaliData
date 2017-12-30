package day2;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadXmlFile2 
{

	public static void main(String argv[]) 
	{

		try 
		{

			File fXmlFile = new File("emp-2.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Turn on validation, and turn off namespaces
			System.out.println("******************************************");			
			System.out.println("*********************************************");
			
			//dbFactory.setValidating(true);//useful for sax parser
			//dbFactory.setNamespaceAware(false);
			//Get Dom Tree using parse method
			
			
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			String rootNodeName=doc.getDocumentElement().getNodeName();
			System.out.println("Root element : " +rootNodeName );
			//NodeList rList = doc.getElementsByTagName(rootNodeName);
			NodeList docNodeList = doc.getElementsByTagName(rootNodeName);
			System.out.println("Document  - Length----------"+docNodeList.getLength());

	 		Node rootNode=docNodeList.item(0);
			System.out.println("Root Node Name: "+rootNode.getNodeName());

			NodeList employeesEleChildList=rootNode.getChildNodes();

			System.out.println("Employees Node Length----------"+employeesEleChildList.getLength());

			getChildElements(employeesEleChildList);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nodeStaffList=eElement.getElementsByTagName(sTag);	
		Node nn= nodeStaffList.item(0);
		NodeList nl=nn.getChildNodes();
		Node nnn=nl.item(0);
		return nnn.getNodeValue();
	}
	
	public static void getChildElements(NodeList  nodeList)
	{
		
		System.out.println("\tNodeList Length :"+nodeList.getLength());
		for (int temp = 0; temp < nodeList.getLength(); temp++) 
		{
			Node nNode = nodeList.item(temp);
			
			short nodeType=nNode.getNodeType();
			switch(nodeType)
			{
			case Node.ATTRIBUTE_NODE:System.out.println("Attribute");break;
			case Node.ELEMENT_NODE: 
					System.out.println("\t\t Element Node Name  :"+nNode.getNodeName());
					 if (nNode.hasAttributes())
					 {
						getAttributeList(nNode);
					 }
					//NodeList nodeList=nNode.getChildNodes();
					getChildElements(nNode.getChildNodes());
					break;									
			case Node.TEXT_NODE:System.out.println("DATA  Node ");
						System.out.println("\t\t\t"+nNode.getNodeValue());
						break;
			case Node.COMMENT_NODE:System.out.println(" Comment Node......");break;
			default:System.out.println(" #Text Node .......");;

			}
		}

		
	}
	
	public static void getAttributeList(Node nNode)
	{
		NamedNodeMap namedNodeMap=nNode.getAttributes();
		for(int i=0;i<namedNodeMap.getLength();i++)
		{
			Node  attNode=namedNodeMap.item(i) ;
			System.out.println("\t\t\t  Attribute Name :" +attNode.getNodeName() + " \t\t\t Attribute Value : "+attNode.getNodeValue());
		}
	}


}
