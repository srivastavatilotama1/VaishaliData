package com.capgemini.salesmanagement.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil 
{
	static String url;
	static String unm;
	static String pwd;
	static String driverClass;
	 
	
	public static Connection getCon()
	{
		Connection con=null;
		Properties prop=DBUtil.loadDBProp();
		url=prop.getProperty("jdbc.url");
		unm=prop.getProperty("jdbc.username");
		pwd=prop.getProperty("jdbc.password");
		driverClass=prop.getProperty("jdbc.driver");
		if(con==null)
		{
			try 
			{
				Class.forName(driverClass);
				con=DriverManager.getConnection(url,unm,pwd);
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
			return con;
		}
	
	public static Properties loadDBProp()
	{
		Properties prop=new Properties();
		try 
		{
			FileInputStream fis=new FileInputStream("dbProp.properties");
			prop.load(fis);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
}
