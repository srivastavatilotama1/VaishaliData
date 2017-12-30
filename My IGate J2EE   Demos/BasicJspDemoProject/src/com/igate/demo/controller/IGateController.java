package com.igate.demo.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.service.IUserService;
import com.igate.demo.service.UserServiceImpl;

public class IGateController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ServletConfig config;
	public IGateController()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method of IGate Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of IGate Controller");
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
		String action=request.getParameter("action");
		IUserService userService=new UserServiceImpl();
		//*****************************************
		if(action!=null)
		{
			//****************1 action*****************
			if(action.equals("showLoginHtml"))
			{
				
				System.out.println("In Controller Coming "+
						"from Home.html going to Login.html");
				
				ArrayList<String> userNameList=
					userService.getAllUsersName();
				System.out.println(" In controller  usernames are: "+
						userService);
				//Keep data in request scope
				request.setAttribute("UserNameList", userNameList);
				RequestDispatcher rd=
					request.getRequestDispatcher
					("jsp/Login.jsp");
				rd.forward(request, response);				
			}		
			
			
			//****************2 action*****************
			if(action.equals("ValidateLogin"))
			{								
				System.out.println("In Controller Coming"+
						"from Login.html going to"+
						"VaildateLogin.jsp");
				
				String uid=request.getParameter("listUserName");
				String pwd=request.getParameter("txtPwd");
				
				LoginDTO loginDto=new LoginDTO				
				(uid, pwd);
				
				RequestDispatcher rdSuccess=null;
				RequestDispatcher rdFailure=null;
				HttpSession session=null;
				if(userService.isValidUser(loginDto))
				{	
					session=request.getSession();
					session.setAttribute("UserName",uid);
				 rdSuccess=
					request.getRequestDispatcher
					("jsp/ValidateLogin.jsp");
				 		rdSuccess.forward(request, response);	
				}
				else
				{
					rdFailure=
						request.getRequestDispatcher
						("jsp/FailureLogin.jsp");	
					rdFailure.forward(request, response);	
				}
			}
		}
		
		//****************3 action*****************
		
		if(action.equals("showRegisterJsp"))
		{
			RequestDispatcher rd=
				request.
				getRequestDispatcher("jsp/Register.jsp");
			rd.forward(request, response);
			
		}
		
		
		//****************4action*****************
		
		if(action.equals("Register"))			
		{
			System.out.println(" In Register action");
			
			String fn=request.getParameter("txtFirstName");
			String ln=request.getParameter("txtLastName");
			String un=request.getParameter("txtUserName");
			String pwd=request.getParameter("txtPassword");
			String phoneNo=request.getParameter("txtMobile");
			long longPhoneNo=Long.parseLong(phoneNo);
			LoginDTO loginDto=new LoginDTO
			(un,pwd,fn,ln,longPhoneNo);
			int noOfRec=userService.addUserInfo(loginDto);
			RequestDispatcher rd=null;
						
			if(noOfRec>=1)
			{
				String msg="Registerd Successfully:";
				request.setAttribute("Message", msg);
				
				ArrayList<String> userNameList=
					userService.getAllUsersName();
				
				//Keep data in request scope
				request.setAttribute("UserNameList", userNameList);
				
				
				
				rd=request.getRequestDispatcher("jsp/Login.jsp");
				rd.forward(request, response);				
			}
			else
			{
				String msg="Registration Fail :";
				request.setAttribute("Message", msg);
				rd=request.getRequestDispatcher("jsp/Login.jsp");
				rd.forward(request, response);	
			}
		}
		
		//************************************************
		else
		{
			out.println(" No Action........");
		}
		
	}

}
