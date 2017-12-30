package com.igate.ch7.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ResourceConnectionPooling
 */
@WebServlet("/ResourceConnectionPooling")
public class ResourceConnectionPooling extends HttpServlet {
	
	@Resource(lookup="java:/jdbc/OracleDS")
	DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from eee1");
			while (rs.next()) {
				pw.println(rs.getInt("empno") + "<br>");
				pw.println(rs.getString("eNAME") + "<br>");
				pw.println(rs.getFloat("sal") + "<br>");
			}
			rs = st.executeQuery("select count(*) from eee1");
			if(rs.next()){
				pw.println("Num of Records:::" + rs.getInt(1));
			}
		} catch (SQLException e1) {
			log("Error is::::::::::" + e1.getMessage());
		}
	}

}
