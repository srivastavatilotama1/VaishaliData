package com.igate.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;
public class DBUtil 
{
	public  static Properties loadDBPropFromFile()
	{
		Properties dbProp=new Properties();
		try 
		{
			FileInputStream fis=new
			FileInputStream("db.properties");
			dbProp.load(fis);
		} 
		catch (Exception e)
		{			
			e.printStackTrace();
			return null;
		}
		return dbProp;		
	}
	
	public static Connection getCon()
	{
		Properties dbProp=DBUtil.loadDBPropFromFile();
		Connection con=null;
		OracleDataSource  ods=null;
		try 
		{
			ods=new OracleDataSource();
			ods.setDriverType(dbProp.getProperty("driver"));
			ods.setURL(dbProp.getProperty("url"));
			ods.setUser(dbProp.getProperty("username"));
			ods.setPassword(dbProp.getProperty("password"));
			con=ods.getConnection();			
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			return null;
		}
		return con;
	}

}
