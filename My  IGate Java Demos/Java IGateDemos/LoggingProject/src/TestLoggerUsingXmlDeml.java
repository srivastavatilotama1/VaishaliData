import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class TestLoggerUsingXmlDeml {

	
	public static void main(String[] args)
	{
		DOMConfigurator.configure("log4j.xml");
		Logger mylogger=Logger.getLogger("TestLoggerUsingPropertyFile");
		mylogger.debug("This is debug level  message ");
		mylogger.info("This is info level  message ");
		mylogger.warn("This is warn level  message ");
		mylogger.error("This is error level  message ");mylogger.debug("This is debug level  message ");
		mylogger.fatal("This is fatal level  message ");
		System.out.println("Done........");

	}

}
