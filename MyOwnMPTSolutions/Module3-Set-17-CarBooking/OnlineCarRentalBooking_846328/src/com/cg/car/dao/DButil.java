package com.cg.car.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.car.exception.CarException;

public class DButil  {
	private static Connection conn=null;
	
	public static Connection getConnection() throws CarException {
		
	
		if(conn==null){
	try {
		InitialContext ic=new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/jeeDS");
			conn=ds.getConnection();
	} catch (NamingException e) {
		throw new CarException("Naming Exception:"+e.getMessage());
		
	}catch (SQLException e) {
		throw new CarException("SqlException:"+e.getMessage());
		
		
		
	}
	
		}
		return conn;
	}

}


