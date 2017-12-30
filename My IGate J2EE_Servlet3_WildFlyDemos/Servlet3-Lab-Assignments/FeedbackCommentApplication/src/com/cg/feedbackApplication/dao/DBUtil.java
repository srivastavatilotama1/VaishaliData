package com.cg.feedbackApplication.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.feedbackApplication.exception.FeedbackException;

public class DBUtil {

	
	public static Connection getConnection() throws FeedbackException{
			
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@ndaoracle.igatecorp.com:1521:orcl11g",
					"lab01trg1","lab01oracle");
		} catch (ClassNotFoundException e) {
		throw new FeedbackException(e.getMessage());
				} catch (SQLException e) {
					throw new FeedbackException(e.getMessage());
					
		}
		
		return con;
		
	}
}
