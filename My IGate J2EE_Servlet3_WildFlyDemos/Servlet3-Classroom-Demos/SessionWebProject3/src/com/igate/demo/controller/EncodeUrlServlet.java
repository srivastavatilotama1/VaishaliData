package com.igate.demo.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncodeUrlServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public EncodeUrlServlet() 
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out=response.getWriter();
		
			String name = request.getParameter("name");
			String password = request.getParameter("pwd");
			
			HttpSession session=request.getSession();
			
			if(name.equals("vaishali") && password.equals("vaishali"))
			{
				session.setAttribute("username",name);
				String string = response.encodeURL("WelcomeEncodeURL.jsp?name=+name+&password=+password");
			
				out.println("<font size = 6><p>Please click here to go forward : </p></font>");
				out.println("<font size = 8><a href ='"+ string +"'>WelcomeEncodeURL.jsp</a></font>");
			}
			else
			{
				String string = response.encodeURL("index-url-rewrite.jsp?name=+name+&password=+password");
				out.println("<font size = 6><p>You have entered a wrong value  : Click here to go back : </p></font>");
				
				out.println("<font size = 8><a href ='"+ string +"'>encodeURL.jsp</a></font>");
			 }
		
	}

}
