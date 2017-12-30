package com.igate.demo.util;
import java.io.IOException;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil 
{
	 static Connection con=null;
	public static Connection getConnection()
	{
		InitialContext initialContext;
		try 
		{
			initialContext = new InitialContext();
			DataSource ds=(DataSource)initialContext.
			lookup("java:/OracleDS");
			con=ds.getConnection();
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}
		
		
		return con;
		
		
		
		
		
	}

}
