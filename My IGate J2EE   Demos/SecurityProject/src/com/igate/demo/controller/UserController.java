package com.igate.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.service.IUserService;
import com.igate.demo.service.UserServiceImpl;

public class UserController extends HttpServlet
{
	IUserService userService=null;
	ServletConfig config;
	private static final long serialVersionUID = 1L;
   
    public UserController()
    {
        super();        
    }
	public void init(ServletConfig config) throws 
	ServletException 
	{
		super.init(config);
		System.out.println(" Init Of UserContrller is invoked");		
	}
	public void destroy()
	{
		System.out.println(" Destroy Of UserContrller is invoked");		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws 
			ServletException, IOException 
	{
		RequestDispatcher rdSuccess=null;
		RequestDispatcher rdFaiure=null;
		String uid=request.getParameter("txtUName");
		String pwd=request.getParameter("txtPwd");
		
		config=getServletConfig();
		ServletContext servletContext=config.getServletContext();
		
		userService=new UserServiceImpl();
		//LoginDTO loginDto=userService.getUserInfo(uid);
		ArrayList<LoginDTO> uList=userService.getAllUsers();
		boolean flag=false;
		PrintWriter pw=response.getWriter();
		
		for(LoginDTO temoDto:uList)
		{
			if(uid.equals(temoDto.getUserName())&&
					pwd.equals(temoDto.getPassword()))
			{
				flag=true;
				break;
			}
			else
			{
				flag=false;
			}			
		}
		if(flag==true)
		{
			rdSuccess=request.
			getRequestDispatcher("html/LoginSuccess.html");
			rdSuccess.forward(request,response);			
		}
		else
		{
			rdFaiure=servletContext.
			getRequestDispatcher("/html/LoginFail.html");
			rdFaiure.forward(request, response);
		}
	}

}
