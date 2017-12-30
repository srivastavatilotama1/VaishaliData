package com.igate.ch7.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectionPoolWildFly
 */
@WebServlet("/ConnectionPoolWildFly")
public class ConnectionPoolWildFly extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/jdbc/OracleDS");
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from eee1");
			while (rs.next()) {
				pw.println(rs.getInt("empno") + "<br>");
				pw.println(rs.getString("eNAME") + "<br>");
				pw.println(rs.getFloat("SAL") + "<br>");
				pw.println(".......................................");
			}
		} catch (NamingException | SQLException e) {
			log("Error is::::::::::" + e.getMessage());
		}
	}

}
