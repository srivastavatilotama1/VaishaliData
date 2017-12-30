package com.igate.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
     ServletConfig config;
     ServletContext ctx;
 
    public WelcomeServlet()
    {
        super();      
    }
	public void init(ServletConfig config) 
	throws ServletException 
	{
		System.out.println("Init Of Welcome Servlet");
		super.init(config);
	}	
	public void destroy() 
	{
		System.out.println("Destroy Of Welcome Servlet");
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out=response.getWriter();		
		ctx=getServletConfig().getServletContext();
		Integer count=(Integer)ctx.getAttribute("MyCount");
		out.println(" Welcome : "+ count.intValue()+
				" Time ");
	}

}
