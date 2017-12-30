package com.cg.cricrec.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class DBUtil {
	private static Connection connection;

	public static Connection getConnection() {
		try
		{
			if(connection==null||connection.isClosed())
			{
				InitialContext context=new InitialContext();
				DataSource ds=(DataSource)context.lookup("java:/OracleDS");
				connection=ds.getConnection();
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
	}
		catch(NamingException n)
		{
			n.printStackTrace();
		}
		return connection;
	}

}
	