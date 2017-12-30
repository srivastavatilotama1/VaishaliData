package com.cg.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.exception.CricketException;

public class DBConnection {
	
	static Connection connection;
	

/****************************************************************************
-Method Name : Connection
-Input parameters : -
-Return Type : -
-Throws : CricketException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : setting up connection.
****************************************************************************/

	public static Connection getConnection() throws CricketException {
		
		//setting up the connection.
		
		try {

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/jdbc/VaishaliDS");
			connection = ds.getConnection();
		} catch (SQLException e) {
			throw new CricketException("SQL Error:" + e.getMessage());

		} catch (NamingException e) {
			throw new CricketException("message from DB/NamingExc:"
					+ e.getMessage());

		}
		return connection;
	}

}
