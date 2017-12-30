package com.igate;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PropertyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties p=new Properties();
		InputStream inputStream =
		    this.getClass().getClassLoader().getResourceAsStream("user.properties");
		p.load(inputStream);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(p.getProperty("name"));
	}

}
