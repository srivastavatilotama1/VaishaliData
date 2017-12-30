package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet 
{
	ServletConfig config;
	int count;
	private static final long serialVersionUID = 1L;       

	public AddCookieServlet()
	{
		super();        
	}	
	public void init(ServletConfig config) throws
	ServletException 
	{
		super.init(config);
		System.out.println(" Init Of Add Cookie Servlet");				
	}
	public void destroy() 
	{
		System.out.println(" Destroy Of Add Cookie Servlet");	
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException 
	{
		String firstName=request.getParameter("txtName");
		PrintWriter out=response.getWriter();
		System.out.println("doPost Of ADDCookieServlet*************************");
		out.println("AddServlet adding first name in cookie</br>");


		Cookie cookieArr[]=request.getCookies();
		Cookie newCookie=null;

		if(cookieArr==null)
		{
			count=1;
			String cookieName="UserName:"+count;
			newCookie=new Cookie(cookieName,firstName);
			response.addCookie(newCookie);
			System.out.println(" In True Block Of AddCookieServlet***************");
		}
		else
		{
			
			count=cookieArr.length;
			System.out.println(" In False Block Of AddCookieServlet****length of Cook is****"+count);
			count=count+1;
			String cookieName="UserName:"+count;
			newCookie=new Cookie(cookieName,firstName);
			response.addCookie(newCookie);				
		}
		
		out.println("<a href='GetCookieServlet'>Get Cookies</a>");
	}

}
