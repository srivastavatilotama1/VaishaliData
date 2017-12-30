package com.cg.eis.util;
import java.io.IOException;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil 
{	
	public static Connection getConnection()
	{
		Connection con=null;
		InitialContext initialContext;
		try 
		{
			initialContext = new InitialContext();
			DataSource ds=(DataSource)initialContext.
					lookup("java:/jdbc/OracleDS");
			con=ds.getConnection();			
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}		
		return con;		
	}
}
