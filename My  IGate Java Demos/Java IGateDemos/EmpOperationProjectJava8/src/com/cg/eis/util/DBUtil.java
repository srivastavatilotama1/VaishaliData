package com.cg.eis.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil 
{
	
	static String url=null;
	static String  username=null;
	static String password=null;		
	
	public static Connection getCon()
	{
	 Connection con=null;
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//	String url="jdbc:oracle:thin:@localhost:1521:XE";
		//	String  username="system";
		//	String password="root";		
		Properties prop=DBUtil.loadProp();
		url=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		if(con==null)
		{
			try
			{
				con=DriverManager.getConnection
						(url,username,password);
				con.setAutoCommit(false);
				System.out.println
				(" Got Connection In DBUtil"+con);
			} 
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}			
		}		
		return con;
	}
	
	public   static Properties  loadProp()
	{		
		Properties myProp=new Properties();
		try
		{
			FileInputStream fis=new
					FileInputStream("jdbc.properties");
			myProp.load(fis);
		} 
		catch (Exception e)
		{			
			e.printStackTrace();
		}
		
		return myProp;
	}

}














