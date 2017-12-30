package com.igate.DemoMVC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.DemoMVC.bean.LoginBean;
import com.igate.DemoMVC.bo.LoginBo;
import com.igate.DemoMVC.exception.UserException;


public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
			
		}
	
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginBean login=new LoginBean();
		System.out.println(request.getParameter("username"));
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		if(request.getParameter("submit").equals("Login"))
		{
			LoginBo logbo=new LoginBo();
			try {
				if(logbo.isUserPresent(login))
				{
					System.out.println(" In servlet true......................");
				javax.servlet.RequestDispatcher reqDis = request.getRequestDispatcher("/success.jsp");
					reqDis.forward(request, response);
				}
				else
				{
					System.out.println(" In servlet false......................");
					RequestDispatcher reqDis = request.getRequestDispatcher("/error.jsp");
					reqDis.forward(request, response);
				}
			} catch (UserException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
