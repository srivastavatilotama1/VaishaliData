package com.igate.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet 
{
	ServletConfig config;
	private static final long serialVersionUID = 1L;
 
    public FirstServlet()
    {
        super();       
    }
	public void init(ServletConfig config) 
	throws ServletException 
	{
		super.init(config);
		//config=
		
		System.out.println(" init Of FirstServlet is invoked");
	}
	public void destroy() 
	{
		System.out.println(" destroy  Of First is invoked");
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException
	{	
		config=getServletConfig();
		
		String cName=config.getInitParameter("compName");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rdHeader=request.
		getRequestDispatcher("html/Header.html");
		rdHeader.include(request, response);				
		out.println("<b>Welcome To : </b>"+cName);
		
		RequestDispatcher rdFooter=
			request.getRequestDispatcher("FooterServlet.Com");
		rdFooter.include(request, response);
		
		
	}

}
