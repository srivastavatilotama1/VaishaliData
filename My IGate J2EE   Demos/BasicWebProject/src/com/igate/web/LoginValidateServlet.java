package com.igate.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;       

	public LoginValidateServlet() 
	{
		super();        
	}
	public void init(ServletConfig config) throws 
	ServletException 
	{		
		System.out.println("Init Method Of LoginValidate Servlet executed");
	}

	public void destroy() 
	{
		System.out.println("Destroy Method Of LoginValidate Servlet executed");
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
		PrintWriter out=response.getWriter();
		//Get  Login Form data
		String uid=	request.getParameter("txtUName");
		String pwd=request.getParameter("txtPwd");
		
		
		RequestDispatcher rd=null;
			
		if(uid.equalsIgnoreCase("IGATE")&&
		(pwd.equalsIgnoreCase("igate")))
		{
			rd=request.getRequestDispatcher("html/LoginSuccess.html");
			rd.forward(request, response);
			
			//out.println("<b>Welcome :</b>  U R valid User");
		}
		else
		{
			rd=request.getRequestDispatcher("html/LoginFail.html");
			rd.forward(request, response);
			//out.println("<b>Sorry :</b>  U R  Not a valid User");			
		}
	}

}
