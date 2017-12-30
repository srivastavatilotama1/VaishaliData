import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class TestLoggerDemo 
{
	public static void main(String[] args) 
	{
		Logger mylogger=Logger.
		getLogger("TestLoggerDemo");
		
		//SimpleLayout simplelayout=new SimpleLayout();
		XMLLayout xmllayout=new XMLLayout();
		
		try 
		{
			FileAppender fileappender=
				new FileAppender(xmllayout,"igate.log",true);
			
			mylogger.addAppender(fileappender);
			mylogger.debug("This is Debug Message");
			mylogger.info("This is log message ");
			mylogger.warn("This is warning message");
			mylogger.error("This is error level message");
			mylogger.fatal("This is fatal error message");
			System.out.println("This is my logging  programe");
			
			int numA[]=new int[1];
			numA[0]=67;
			System.out.println(" numA[0] : ="+numA[1]);;
		} 
		catch (Exception e) 
		{		
			System.out.println(" Arrray Exception : "+
					e.getMessage());
			mylogger.error(e.getMessage());
			e.printStackTrace();
			
		}

	}

}
