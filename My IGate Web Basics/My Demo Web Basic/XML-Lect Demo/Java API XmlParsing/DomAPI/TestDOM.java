package day2;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class TestDOM {
	
	public static void main(String args[])
	{
		try{
			File f=new File("emp-2.xml");
			if(f.exists())
			{
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse(f);
				
				System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());
				System.out.println("Elements in "+doc.getDocumentElement().getNodeName()+" are....");
				//String node_name=doc.getDocumentElement().;
				NodeList n=doc.getChildNodes();
				//System.out.println(n.item(0).getChildNodes().item(0).getNodeName());
				//NodeList nList=doc.getElementsByTagName("staff");
		
				
				for(int tmp=0;tmp<n.getLength();tmp++)
				{
					Node nNode=n.item(tmp);
					System.out.println("...."+nNode.getNodeName()+"...."+nNode.getNodeValue()+"\t\t\t"+nNode.getTextContent().toString());
					/*if(nNode.getNodeType()==Node.ELEMENT_NODE)
					{
						Element eElement=(Element)nNode;
						System.out.println("First Name : "+getTagValue("firstname",eElement));
						System.out.println("Last Name : "+getTagValue("lastname",eElement));
						System.out.println("Nick Name : "+getTagValue("nickname",eElement));
						System.out.println("Salary : "+getTagValue("salary",eElement));
						
					}*/
			}
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static String getTagValue(String tag, Element element) {
		// TODO Auto-generated method stub
		NodeList nlList=element.getElementsByTagName(tag).item(0).getChildNodes();
		
		Node nValue=(Node)nlList.item(0);
		
		return nValue.getNodeValue();
	}

}
