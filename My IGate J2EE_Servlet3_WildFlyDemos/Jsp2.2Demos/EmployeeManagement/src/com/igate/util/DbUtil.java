package com.igate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DbUtil
{
	
	public  static Connection getConnection()
	{
		InitialContext ic;
		DataSource ds;
		Connection con=null;
		try 
		{
			ic = new InitialContext();
			// ds=(DataSource)ic.lookup("java:/jdbc/VaishaliDS");	
			//	DataSource ds=(DataSource)ic.lookup("MyDS");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					 "system","root");	
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//throw new EmployeeException("some databse eror..."+e.getMessage());
		} 	
		return con;
		
		
	}
}




