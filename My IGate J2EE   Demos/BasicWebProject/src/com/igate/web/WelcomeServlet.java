package com.igate.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WelcomeServlet extends GenericServlet
{
	private static final long serialVersionUID = 1L;     
    public WelcomeServlet() 
    {
    	super();       
    }
	public void init(ServletConfig config) 
	throws ServletException 
	{
		System.out.println("Init method is executed");		
	}
	public void destroy() 
	{
		System.out.println("Dest method is executed");				
	}

	public void service(ServletRequest request, ServletResponse response) 
	throws ServletException, IOException 
	{
		
		PrintWriter pw=response.getWriter();
		
		pw.print("<html><body bgcolor='pink'>");
		pw.println("<b>Welcome To IGATE</b>");
		pw.print("</body></html>");
	}

}
