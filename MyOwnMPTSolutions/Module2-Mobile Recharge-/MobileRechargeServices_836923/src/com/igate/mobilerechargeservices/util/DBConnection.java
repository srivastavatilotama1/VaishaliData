 package com.igate.mobilerechargeservices.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.igate.mobilerechargeservices.exception.MobileServicesException;



public class DBConnection
{

		private static DBConnection dbConnection;
		private DBConnection()	{	}
		
		public static  Connection getDBConnection() 
		{			
			Connection conn=null;
			try 
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");				
					conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","root");
					System.out.println("hhhh");
			
				} 
					catch (Exception e)
				{				
						e.printStackTrace();
				}
			
			return conn;
				
		}
}




