package com.igate.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PropertyServlet() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		
		Properties p=new Properties();
		InputStream inputStream =
		    this.getClass().getClassLoader().getResourceAsStream("db.properties");
		p.load(inputStream);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(p.getProperty("driver"));
	}

}
