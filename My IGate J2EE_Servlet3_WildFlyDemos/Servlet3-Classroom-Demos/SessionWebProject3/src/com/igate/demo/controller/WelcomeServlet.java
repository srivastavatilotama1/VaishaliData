package com.igate.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public WelcomeServlet() 
    {
        super();        
    }

	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	System.out.println("init Of Welcome servlet");
	}

	public void destroy() 
	{
		System.out.println("destroy Of Welcome servlet");
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm=request.getParameter("name");
		PrintWriter out=response.getWriter();
		out.println(" Welcome : "+nm);
		
	}

}
