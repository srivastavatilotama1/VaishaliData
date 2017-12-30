package com.igate.util;

/**
 * @author vivek
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil 
{
	private static Properties loadProperties(String fileName) 
	{
	     Properties dbProp = new Properties();
	        try
	        { 
	        	InputStream  propsFile = new FileInputStream(fileName);
	        	dbProp .load(propsFile);
	        
	            propsFile.close();
	        } 
	        catch (IOException ioe) 
	        {
	        	  ioe.printStackTrace();
	        }     
	        return dbProp ;    
	    }

	public static Connection getConnection()
	{
		String fn="db.properties";			
		Properties dbProp=DBUtil.loadProperties(fn);	
		OracleDataSource ods;
		Connection con=null;
		try 
		{
			ods = new OracleDataSource();
			ods.setDriverType(dbProp .getProperty("driver")); 		
			ods.setURL(dbProp .getProperty("url")); 
			ods.setUser(dbProp .getProperty("username")); 
			ods.setPassword(dbProp .getProperty("password")); 			
			con = ods.getConnection(); 	
			con.setAutoCommit(false);
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
			try 
			{
				con.close();
			} catch (SQLException e1) 
			{				
				e1.printStackTrace();
			}
			return null;
		}	
		return con;
		
	}

}
