package com.igate.log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class IGateLogger 
{
	 static Logger  igateLogger=null;
	 public static Logger getIGateLogger()
	 {
		 PropertyConfigurator.configure("Log4j.properties");
		 igateLogger= Logger.getLogger("IGateEmpLogger");
		 return igateLogger;		 
	 }
}
