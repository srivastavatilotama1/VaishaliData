package com.igate.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FooterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public FooterServlet() 
    {
        super();       
    }
	public void init(ServletConfig config) 
	throws ServletException 
	{
		System.out.println(" Init Of FooterServlet");
	}
	public void destroy()
	{
		System.out.println(" Destroy Of FooterServlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request,response);		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		pw.println("</br>**********Footer Servlet***************");
		pw.println("<a href=' '>About Us</a>");
		pw.println("@CopyRights Patani");
		
	}

}
