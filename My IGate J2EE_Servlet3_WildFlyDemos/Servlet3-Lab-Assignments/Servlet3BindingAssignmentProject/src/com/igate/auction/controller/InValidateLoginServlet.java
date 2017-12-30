package com.igate.auction.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InValidateLoginServlet")
public class InValidateLoginServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
       
    
   	ServletConfig config;
	public InValidateLoginServlet()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method of InValidateLoginServlet Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of InValidateLoginServlet  Controller");
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
		PrintWriter out=response.getWriter();		
		out.println("<font color='red'>U R Invalid User</font>");
		out.println("<form action='LoginControllerServlet?action=ValidateLogin' method='post'>");
		out.println("<table border='1' style='text-align: center'>");
		out.println("<tr>");
		out.println("<td>User name: </td>");
		out.println("<td><input type='text' name='txtUname'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Password: </td>");
		out.println("<td><input type='password' name='txtPwd'></td>");
		out.println("</tr>");
		out.println("<tr>");		
		out.println("<td><input type='submit' value='Login'/>");
		out.println("<input type='reset' value='Clear'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
	}	
}
