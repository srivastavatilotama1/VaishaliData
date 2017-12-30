import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class DomReadXmlFile
{
	public static void main(String argv[])
	{
		try 
		{
			File fXmlFile = new File("emp-2.xml");
			DocumentBuilderFactory dbFactory = 
					DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = 
					dbFactory.newDocumentBuilder();
			System.out.println("******************************");
				
			Document doc = dBuilder.parse(fXmlFile);
			String rootNodeName=
					doc.getDocumentElement().getNodeName();
			System.out.println("Root element :<" +rootNodeName+">" );
			NodeList docNodeList = 
					doc.getElementsByTagName(rootNodeName);
			System.out.println("Document  - Length----------"+
					docNodeList.getLength());
	 		Node node=docNodeList.item(0);
			getChildElements(node);			
		} 
		catch (Exception e) {	e.printStackTrace();}
	}
	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nodeStaffList=eElement.getElementsByTagName(sTag);	
		Node nn= nodeStaffList.item(0);
		NodeList nl=nn.getChildNodes();
		Node nnn=nl.item(0);
		return nnn.getNodeValue();
	}	
	public static void getChildElements(Node  node)
	{		
		NodeList nodeList=node.getChildNodes();
		for (int temp = 0; temp < nodeList.getLength(); temp++) 
		{
			Node nNode = nodeList.item(temp);			
			short nodeType=nNode.getNodeType();
			switch(nodeType)
			{
			case Node.ATTRIBUTE_NODE:
				System.out.println("Attribute");
				break;
			case Node.ELEMENT_NODE: 
				System.out.println("\t\t :<"+nNode.getNodeName()+">");
				if (nNode.hasAttributes())
					 {
						getAttributeList(nNode);
					 }
					getChildElements(nNode);
					break;									
			case Node.TEXT_NODE:
				System.out.println("DataNode: "+nNode.getNodeName()+":"  +nNode.getNodeValue());
				break;
			case Node.COMMENT_NODE:
				System.out.println(" Comment Node:");
				break;
			default:System.out.println("#Text Node ");
			}
		}		
	}	
	public static void getAttributeList(Node nNode)
	{
		NamedNodeMap namedNodeMap=nNode.getAttributes();
		for(int i=0;i<namedNodeMap.getLength();i++)
		{
			Node  attNode=namedNodeMap.item(i) ;
			System.out.println("\t\t\t" +attNode.getNodeName() + 
			" : "+attNode.getNodeValue());
		}
	}

}