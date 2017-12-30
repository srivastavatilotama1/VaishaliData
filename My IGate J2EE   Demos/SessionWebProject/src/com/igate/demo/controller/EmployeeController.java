package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public EmployeeController()
    {
        super();
        
    }	
	public void init(ServletConfig config) throws 
	ServletException 
	{
		System.out.println("Init Of employee Controller");
	}
	public void destroy() 
	{
		System.out.println("Destroy Of employee Controller");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("USERNAME");
		
		
		
		PrintWriter pw=response.getWriter();
		pw.println("</br>In EmployeeController is Session New? :"+
				session.isNew());
		pw.println("</br> In EmployeeController Session id is :"+
				session.getId());
		pw.println("</br>Session was invalidated here");
		session.invalidate();
		pw.println(" Wecome : "+uid );
		pw.println("</br><a href='AddEmpServlet'>Add Emp</a>");
	}

}
