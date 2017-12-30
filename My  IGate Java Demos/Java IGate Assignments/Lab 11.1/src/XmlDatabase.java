import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.igate.util.DBUtil;

/**
 * @author vivek
 * 
 */

public class XmlDatabase {

	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileInputStream fin = null;
		try {
			 fin = new FileInputStream("db.properties");
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("Select * from mobiles");
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element Mobiles = doc.createElement("Mobiles");
			doc.appendChild(Mobiles);
			Comment comment = doc.createComment("Comment");
			Mobiles.appendChild(comment);
			Element Mobileid;
			Element MobileName;
			Element price;
			Element quantity;
			Text Text1, Text2, Text3, Text4;

			while (rs.next()) 
			{
				Mobileid = doc.createElement("Mobileid");
				Mobiles.appendChild(Mobileid);
				
				Text1 = doc.createTextNode((rs.getInt(1) + "\n"));
				Mobileid.appendChild(Text1);

				MobileName = doc.createElement("MobileName");
				Mobiles.appendChild(MobileName);
				
				Text2 = doc.createTextNode((rs.getString(2) + "\n"));
				MobileName.appendChild(Text2);

				price = doc.createElement("Price");
				Mobiles.appendChild(price);
				
				Text3 = doc.createTextNode((rs.getInt(3) + "\n"));
				price.appendChild(Text3);

				quantity = doc.createElement("Quantity");
				Mobiles.appendChild(quantity);
				
				Text4 = doc.createTextNode((rs.getInt(4) + "\n"));
				quantity.appendChild(Text4);
			}

			Mobiles.normalize();

			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			Source src = new DOMSource(doc);
			Result dest = new StreamResult("Output.xml");
			aTransformer.transform(src, dest);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
