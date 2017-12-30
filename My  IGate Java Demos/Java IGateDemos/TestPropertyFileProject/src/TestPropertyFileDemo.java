import java.io.*;
import java.util.*;

public class TestPropertyFileDemo
{
	private static void saveProperties(Properties p) 
	{
	    try 
	    { 
	    	OutputStream propsFile = new FileOutputStream("myproperty.properties");
	            p.store(propsFile, "Properties File to the Test Application");
	            propsFile.close();
	        }
	    catch (IOException ioe) 
	        {
	        		        	ioe.printStackTrace();
	        }
	}
	private static Properties loadProperties(String fileName) 
	{
	     Properties tempProp = new Properties();
	        try
	        { 
	        	InputStream  propsFile = new FileInputStream(fileName);
	            tempProp.load(propsFile);
	            System.out.println("*******************"+tempProp.getProperty("password"));
	            System.out.println("*******************"+tempProp.getProperty("username"));
	            propsFile.close();
	        } 
	        catch (IOException ioe) 
	        {
	        	  ioe.printStackTrace();
	        }     
	        return tempProp;     }

	
	
	public static void main(String[] args) 
	{
		String fn="D://VaishaliJavaWS/TestPropertyFileProject/src/myproperty.properties";
		
		String fw="me.properties";
		TestPropertyFileDemo.loadProperties(fn);
		Properties p=new Properties();
		p.setProperty("a", "a1");
		p.setProperty("b", "b1");
		TestPropertyFileDemo.saveProperties(p);
	}

}
