package com.igate.util;



import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.igate.exception.UsersException;


public class DbUtil
{
	
	public  static Connection getConnection()throws UsersException
	{
		InitialContext ic;
		DataSource ds;
		try 
		{
			ic = new InitialContext();
			 ds=(DataSource)ic.lookup("java:/OracleDS");	
			//	DataSource ds=(DataSource)ic.lookup("MyDS");	
				return ds.getConnection();
		}
		catch (Exception e)
		{
			throw new UsersException("some databse eror..."+e.getMessage());
		} 	
		
	}
}




