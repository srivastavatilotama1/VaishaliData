package com.igate.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ServletConfig con;

	public LoginServlet()
	{
		super();       
	}
	public void init(ServletConfig config) 
	throws ServletException 
	{
		super.init(config)	;
		System.out.println(" Init Of Login Servlet");
	}
	public void destroy()
	{
		System.out.println(" Destroy Of Login Servlet");
	}
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, 
		IOException 
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession(true);
		
		System.out.println(" In Login Servlet  is session New?"+
				session.isNew());
		
		System.out.println(" In Login Servlet  is session Id is"+
				session.getId());
		
		
		RequestDispatcher rdSuccess=null;
		RequestDispatcher rdFaiure=null;
		con=getServletConfig();
		ServletContext servletContext=con.getServletContext();
		servletContext.setAttribute("CN", "IGATE");
		
		PrintWriter out=response.getWriter();
		System.out.println(" In Login servlet DoPost.....");
		String uid=request.getParameter("txtUid");
		String pwd=request.getParameter("txtPwd");
		System.out.println(uid +": "+pwd);
		
		session.setAttribute("USERNAME", uid);
		if(uid.equalsIgnoreCase("Igate")&&
				pwd.equalsIgnoreCase("IGATe"))
		{
			rdSuccess=request.
			getRequestDispatcher("/SuccessServlet");
			rdSuccess.forward(request,response);
		}
		else
		{
			rdFaiure=servletContext.
			getRequestDispatcher("/FailureServlet");
			rdFaiure.forward(request, response);
			
			
		}
		

	}

}
