package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddEmpServlet extends HttpServlet 
{
	ServletConfig con;
	private static final long serialVersionUID = 1L;
   
    public AddEmpServlet() 
    {
        super();        
    }
	public void init(ServletConfig config) 
	throws ServletException
	{
		super.init(config);	
		System.out.println(" Init Of add Empservlet");
	}
	public void destroy()
	{
		System.out.println(" destroy  Of add Empservlet");
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException, IOException
	{
		con=getServletConfig();
		ServletContext ctx=con.getServletContext();
		String compName=(String)ctx.getAttribute("CN");
		
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String empName=(String)session.getAttribute("USERNAME");
		pw.print(empName+
				"</br> Emp was  joined and added .... In "+
				compName);
		
		pw.print("</br>In AddEmpServlet Is Session New? : "+
				session.isNew());
		pw.print("</br>In AddEmpServlet  Session ID is ? : "+
				session.getId());
	}

}
