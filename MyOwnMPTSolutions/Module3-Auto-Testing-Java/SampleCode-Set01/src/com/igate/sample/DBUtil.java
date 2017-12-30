package com.igate.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBUtil {

	private static Connection connection;
	private final static Logger logger = Logger.getLogger(DBUtil.class);

	public static Connection getConnection() throws SampleException {
		logger.info("Requesting for new connection");
		try {
			if (connection == null || connection.isClosed()) {
				Properties props = new Properties();
				props.load(new FileInputStream("resources/oracle.properties"));
				connection = DriverManager.getConnection(
						props.getProperty("jdbc.url"),
						props.getProperty("jdbc.user"),
						props.getProperty("jdbc.password"));
			}
			logger.info("Request for new connection completed");
		} catch (SQLException | IOException e) {
			logger.error("Problem in getting connection! Details"+e.toString());
			throw new SampleException("Problem in getting connection! Details:"
					+ e.getMessage());
		}
		return connection;
	}
}
