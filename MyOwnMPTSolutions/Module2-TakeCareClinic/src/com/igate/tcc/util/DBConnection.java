package com.igate.tcc.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {

		private static DBConnection dbConnection;
		
		private DBConnection()
		{
			
		}
		
		public Connection getDBConnection() 
		{
			InputStream propsFile;
			Properties tempProp = new Properties();
			Connection conn=null;
			
			try {
				propsFile = new FileInputStream("Resources/jdbc.properties");
				tempProp.load(propsFile);
				propsFile.close();
				
				//tempProp.list(System.out);   ///to print the data in property file
				String url=tempProp.getProperty("jdbc.url");
				String userName=tempProp.getProperty("jdbc.username");
				String password=tempProp.getProperty("jdbc.password");
				
				/*OracleDataSource dataSource=new OracleDataSource();
				
				dataSource.setURL(url);
				dataSource.setUser(userName);
				dataSource.setPassword(password);
				*/
				 conn=DriverManager.getConnection(url,userName,password);
				
				
				
				
			} 
			catch (IOException exception) 
			{
				
				System.err.println("Enter the proper file"+exception.getMessage());
			}
			catch (SQLException exception)
			{
				System.err.println("Check the Login Credentials"+exception.getMessage());
			}
			return conn;
			
		}
		
		public static DBConnection getInstance() throws SQLException
		{
			if(dbConnection==null)
			{
				dbConnection=new DBConnection();
				//dbConnection.getDBConnection();
			}
			return dbConnection;
		}

		
		
	}




