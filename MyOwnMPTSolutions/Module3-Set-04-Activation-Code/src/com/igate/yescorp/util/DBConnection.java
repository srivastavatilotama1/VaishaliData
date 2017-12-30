package com.igate.yescorp.util;

import java.sql.Connection;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.igate.yescorp.exception.FirmException;

public class DBConnection {
	public static Connection getConnection() throws FirmException{
		Connection connection=null;
		InitialContext context;
		try {
			context = new InitialContext();
			DataSource ds=(DataSource) context.lookup("java:/jdbc/VaishaliDS");
			connection=ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new FirmException("Cannot connect to the Database");
		}
		return connection;
	}
}
