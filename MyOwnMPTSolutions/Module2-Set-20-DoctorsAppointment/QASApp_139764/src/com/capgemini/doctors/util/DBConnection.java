package com.capgemini.doctors.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.doctors.exception.DoctorException;

public class DBConnection {
	public static Connection getConnection() throws DoctorException {
		Connection con = null;
		Properties props = new Properties();
		try {
			FileReader fr = new FileReader("resources/jdbc.properties");
			props.load(fr);

			String url = props.getProperty("jdbcurl");
			String user = props.getProperty("jdbcuser");
			String password = props.getProperty("jdbcpassword");
			con = DriverManager.getConnection(url, user, password);

		} catch (FileNotFoundException e) {
			throw new DoctorException("File not found");
		} catch (IOException e) {
			throw new DoctorException("Unable to read properties file");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return con;
	}
}
