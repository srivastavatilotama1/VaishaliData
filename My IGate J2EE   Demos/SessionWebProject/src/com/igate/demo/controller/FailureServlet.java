package com.igate.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailureServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	ServletConfig congig;
	public FailureServlet() 
	{
		super();        
	}
	public void init(ServletConfig config) 
	throws ServletException 
	{
		super.init(config);
		System.out.println(" Init Of failure Servlet");
	}

	public void destroy()
	{
		System.out.println(" Destroy  Of Failure Servlet");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();		
		String unm=request.getParameter("txtUid");
		pw.print(" Sorry   : "+unm+" U R Not a valid user ");
	}


}
