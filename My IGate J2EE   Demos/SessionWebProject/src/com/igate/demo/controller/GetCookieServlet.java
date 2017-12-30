package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet 
{
	ServletConfig config;
	private static final long serialVersionUID = 1L;    
    public GetCookieServlet()
    {
    	super();        
    }

	public void init(ServletConfig config) 
	throws ServletException 
	{
		super.init(config);
		System.out.println(" Init Of GetCokkies Servlet");
	}
	public void destroy() 
	{
		System.out.println(" Destroy  Of GetCokkies Servlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		System.out.println(" In doPost Of GetCookieServlet..............");
		
		Cookie cookieArr[]=request.getCookies();
		
		if (cookieArr==null)
		{
			out.println(" </br>No Cookes Set </br>");
		}
		else
		{			
			for(int i=0;i<cookieArr.length;i++)
			{
				String cookieName=cookieArr[i].getName();
				String cookieValue=cookieArr[i].getValue();
				out.println ("</br> CookieName : "+cookieName+
						"  Cookie Value : "+
						cookieValue);
			}
		}
		
	}

}
