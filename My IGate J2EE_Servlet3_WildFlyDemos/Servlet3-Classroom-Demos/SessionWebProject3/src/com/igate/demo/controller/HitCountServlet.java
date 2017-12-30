package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCountServlet extends HttpServlet 
{
	int no;
	private static final long serialVersionUID = 1L;
	ServletConfig config;
    public HitCountServlet() 
    {
        super();       
    }
	public void init(ServletConfig config) throws 
	ServletException 
	{
		super.init(config);
		System.out.println(" In It method Of HitCount Servlet");	
	}
	public void destroy() 
	{
		System.out.println(" Destroy method Of HitCount Servlet");		
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	 doPost(request,response);	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		String userId=request.getParameter("txtUid");
		System.out.println(" In Url Rewrite Servlet User Id Is :"+
				userId);
		
		
		
		String id=request.getParameter("ID");
		if(id==null)
		{
			no=1;
			id="1";
		}
		 no=Integer.parseInt(id);
		 no++;
		out.println(" <h1>HitCount  : "+no+"</h1>");
		 out.println("<a href='HitCountServlet?ID="+no+"'>");
		 out.println("Go To URL ReWriteServlet</a>");		 
		 
		 out.println("<a href='WelcomeServlet?name="+userId+"'>");
		 out.println("Go To Welcome Servlet</a>");
		
	}

}
