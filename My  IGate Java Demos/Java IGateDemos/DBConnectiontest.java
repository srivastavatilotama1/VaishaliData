package com.igate.mobilerecharge.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

//import com.igate.mobile.util.DBConnection;

public class DBConnectiontest
{

	@Test
	
	
	public void getConnection() 
	{
		InputStream propsFile;
		Properties tempProp = new Properties();
		Connection conn=null;
		
		try {
			propsFile = new FileInputStream("resources/jdbc.properties");
			tempProp.load(propsFile);
			propsFile.close();
			
			//tempProp.list(System.out);   ///to print the data in property file
			String url=tempProp.getProperty("jdbc.url");
			String userName=tempProp.getProperty("jdbc.username");
			String password=tempProp.getProperty("jdbc.password");
			
			/*OracleDataSource dataSource=new OracleDataSource();
			
			dataSource.setURL(url);
			dataSource.setUser(userName);
			dataSource.setPassword(password);
			
			 conn=dataSource.getConnection();
			*/
conn = DriverManager.getConnection(url, userName,password);
			
			
		} 
		catch (IOException exception) 
		{
			
			System.err.println("Enter the proper file"+exception.getMessage());
		}
		catch (SQLException exception)
		{
			System.err.println("Check the Login Credentials"+exception.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}