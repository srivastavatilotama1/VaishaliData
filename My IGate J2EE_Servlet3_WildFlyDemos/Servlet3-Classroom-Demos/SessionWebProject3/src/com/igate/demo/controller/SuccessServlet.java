package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ServletConfig congig;
	public SuccessServlet() 
	{
		super();        
	}
	public void init(ServletConfig config) 
	throws ServletException 
	{
		super.init(config);
		System.out.println(" Init Of Success Servlet");
	}

	public void destroy()
	{
		System.out.println(" Destroy  Of Success Servlet");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		HttpSession ses=request.getSession();
		
		
		PrintWriter pw=response.getWriter();
		pw.println("</br>In SuccessServlet is Session New? :"+
				ses.isNew());
		pw.println("</br> In SuccessServlet Session id is :"+
				ses.getId());
				
		String unm=request.getParameter("txtUid");
				pw.print(" Welcome  : "+unm+"  U R valid user ");
		pw.print("</br><a href='EmployeeController'>Do Emp Operation");
		pw.println("</a>");
	}

}
