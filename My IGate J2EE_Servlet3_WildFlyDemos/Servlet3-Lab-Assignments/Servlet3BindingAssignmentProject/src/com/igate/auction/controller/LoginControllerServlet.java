package com.igate.auction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.auction.dao.UserDaoImpl;
import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.dto.LoginDTO;
import com.igate.auction.service.IItemsForBidService;
import com.igate.auction.service.ItemsForBidServiceImpl;

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	ServletConfig config;
	public LoginControllerServlet()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method of LoginControllerServlet Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of LoginControllerServlet  Controller");
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
		UserDaoImpl userService=new UserDaoImpl();

		IItemsForBidService itemBidService=new ItemsForBidServiceImpl();
		//*****************************************
		if(action!=null)
		{
			//****************1 action*****************
			if(action.equals("showLoginHtml"))
			{

				System.out.println("In Controller Coming "+
						"from Home.html going to Login.html");

				RequestDispatcher rd=
						request.getRequestDispatcher
						("Login.html");
				rd.forward(request, response);				
			}				

			//****************2 action*****************
			if(action.equals("ValidateLogin"))
			{								
				System.out.println("In Controller Coming"+
						"from Login.html going to"+
						"either valid or invalid servlet");

				String uid=request.getParameter("txtUname");
				String pwd=request.getParameter("txtPwd");

				LoginDTO loginDto=new LoginDTO	(uid, pwd);

				RequestDispatcher rdSuccess=null;
				RequestDispatcher rdFailure=null;
				HttpSession session=null;
				//session=request.getSession();
				ArrayList<ItemsForBid> itemBidList=null;

				if(userService.isValidUser(loginDto))
				{	
					//session.invalidate();					
					session=request.getSession(true);
					session.setAttribute("UserName",uid);

					itemBidList=	itemBidService.getAllBidItems();
					System.out.println("In LoginController servlet ...."+itemBidList);
					session.setAttribute("ItemBidList",itemBidList);
					rdSuccess=
							request.getRequestDispatcher
							("ValidateLoginServlet");
					rdSuccess.forward(request, response);	
				}
				else
				{
					rdFailure=
							request.getRequestDispatcher
							("InValidateLoginServlet");	
					rdFailure.forward(request, response);	
				}
			}				
			//***********************************
			if(action.equals("showOriginalBidItem"))
			{								
				System.out.println("In Login Controller Coming"+
						"from ShowMyBidItemsServlet  going to"+
						"ValidateLoginServlet");						

				RequestDispatcher rdSuccess=null;				
				HttpSession session=null;
				ArrayList<ItemsForBid> itemBidList=null;				

				session=request.getSession();
				String uid=(String)session.getAttribute("UserName");

				itemBidList=	itemBidService.getAllBidItems();
				System.out.println("In LoginController servlet ...."+itemBidList);
				session.setAttribute("ItemBidList",itemBidList);
				rdSuccess=
						request.getRequestDispatcher
						("ValidateLoginServlet");
				rdSuccess.forward(request, response);	
			}			
		}
		//****************************************************
		if(action.equals("logOutUser"))
		{								
			System.out.println("Login Controller logouy=t.......");		

			RequestDispatcher rdSuccess=null;

			HttpSession session=null;
			session=request.getSession();	
			session.removeAttribute("UserName");
			session.removeAttribute("ItemBidList");
			session.invalidate();					
						 rdSuccess=
				request.getRequestDispatcher
				("LoginControllerServlet?action=showLoginHtml");
			 		rdSuccess.forward(request, response);						
		}		

		//************************************************
		else
		{
			out.println(" No Action........");
		}

	}

}
