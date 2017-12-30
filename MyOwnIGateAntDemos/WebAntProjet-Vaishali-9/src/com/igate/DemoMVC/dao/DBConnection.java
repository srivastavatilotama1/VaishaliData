package com.igate.DemoMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.igate.DemoMVC.exception.UserException;


public class DBConnection {

	static DBConnection dbConnection = null;

	DBConnection() throws UserException {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			throw new UserException(e.getMessage());
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager
				.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
						"system", "root");

		return con;
	}

}
