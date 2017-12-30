package com.igate.auction.util;


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
			lookup("java:/jdbc/OracleDS");
			con=ds.getConnection();
			//con.setAutoCommit(false);
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}
		
		
		return con;
		
	}

}
