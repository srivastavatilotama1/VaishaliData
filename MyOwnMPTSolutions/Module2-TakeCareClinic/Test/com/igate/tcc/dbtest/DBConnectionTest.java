package com.igate.tcc.dbtest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import junit.framework.Assert;
import oracle.jdbc.pool.OracleDataSource;

import org.junit.Test;


public class DBConnectionTest
{

	@Test
	public void dbConnectionTest() throws Exception {
		
		InputStream propsFile;
		Properties tempProp = new Properties();
		Connection conn=null;
		
		propsFile = new FileInputStream("resources/jdbc.properties");
		tempProp.load(propsFile);
		propsFile.close();
			
			
		String url=tempProp.getProperty("jdbc.url");
		String userName=tempProp.getProperty("jdbc.username");
		String password=tempProp.getProperty("jdbc.password");
			
		OracleDataSource dataSource=new OracleDataSource();
			
		dataSource.setURL(url);
		dataSource.setUser(userName);
		dataSource.setPassword(password);
			
		conn=dataSource.getConnection();
			
			
		 Assert.assertNotNull("Connection Object is not created ",conn);
		
		
	}
}
