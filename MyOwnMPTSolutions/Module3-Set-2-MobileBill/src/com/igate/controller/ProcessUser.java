package com.igate.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.dto.UserDto;
import com.igate.exception.UsersException;
import com.igate.service.UserService;

public class ProcessUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ProcessUser() 
	{
		super();     
	}
	public void init(ServletConfig config) throws ServletException
	{	
		super.init(config);
	}
	public void destroy()
	{		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		System.out.println("In doget..................");
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In doPost..................");
		PrintWriter pw=response.getWriter();

		String action=request.getParameter("action");
		System.out.println("In doPost.................."+action);
		UserService userService = new UserService();

		if(action!=null)
		{
			if(action.equals("Register"))
			{
				//Create a new HttpSession
				HttpSession userSession=request.getSession(true);
				UserDto userDTO = new UserDto();

				userDTO.setName(request.getParameter("custName"));
				userDTO.setMobilenumber(request.getParameter("mobileNo"));
				userDTO.setUsername(request.getParameter("uName"));
				userDTO.setPassword(request.getParameter("pass"));				
				//double bill = (double) Math.random();
				double	bill=(double)Math.round(Math.random()*100);

				userDTO.setBillamount(bill);
				System.out.println(userDTO);	
				try 
				{
					userService.insertUsers(userDTO);
				}
				catch (UsersException e) 
				{
					System.out.println("User Exception in Controller Servlet....");	
					e.printStackTrace();
				}

				userSession.setAttribute("UserDetails",userDTO);

				RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
				rd.forward(request,response);				
			}
			
			if(action.equals("PayBill"))
			{				
				HttpSession useSession = request.getSession(true);
				UserDto userDTO =(UserDto) useSession.getAttribute("UserDetails");					
			    System.out.println(" Paybill action...."+userDTO);
			     RequestDispatcher rd=request.getRequestDispatcher("/jsps/payBill.jsp");
				rd.forward(request,response);				
			}
			
			if(action.equals("Pay"))
			{
				int amt=Integer.parseInt(request.getParameter("amount"));
				String cno=request.getParameter("cardnumber");
				
				System.out.println(" Pay action...."+amt);
				request.setAttribute("AMOUNT",amt);
				request.setAttribute("CNO", cno);
				
				RequestDispatcher rd=request.getRequestDispatcher("/jsps/payBill.jsp");
				rd.forward(request,response);
			}		
			
			if(action.equals("Success"))
			{				
				System.out.println(" Success action....");
				Integer amt=(Integer)request.getAttribute("AMOUNT");
				System.out.println(" Success action...."+amt.intValue());
				HttpSession useSession = request.getSession(true);
				UserDto userDTO =(UserDto) useSession.getAttribute("UserDetails");					
				
				try 
				{
					int penAmt=userService.updateAmt(amt,userDTO);
					request.setAttribute("PendingAmt", penAmt);
					RequestDispatcher rd=request.getRequestDispatcher("jsps/success.jsp");
					rd.forward(request,response);
				}
				catch (UsersException e) 
				{
					System.out.println("User Exception in Controller Servlet....");	
					e.printStackTrace();
				}	
			}				
			//Login.jsp
			if(action.equals("Login"))
			{				
				System.out.println(" Login action....");	
				
				try 
				{
					request.setAttribute("UserNames", userService.getUsers());
				
					RequestDispatcher rd=request.getRequestDispatcher("jsps/login.jsp");
					rd.forward(request,response);
				}
				catch (Exception e) 
				{
					System.out.println("User Exception in Controller Servlet....");	
					e.printStackTrace();
				}	
			}	
			
			
			//ShowBill.jsp
			if(action.equals("ShowBillAmt"))
			{	
				String username=request.getParameter("uName");
				String pwd=request.getParameter("pass");
				 System.out.println(" ShowBillAmt action...."+username);
				try 
				{
					UserDto userDto=userService.getBillAmt(username);
					HttpSession useSession = request.getSession(true);
					useSession.setAttribute("UserDetails",userDto);					
				    System.out.println(" ShowBillAmt action...."+userDto);
					RequestDispatcher rd=request.getRequestDispatcher("/jsps/payBill.jsp"); // 1
					rd.forward(request,response);	
				}
				catch (Exception e) 
				{
					System.out.println("User Exception in Controller Servlet....");	
					e.printStackTrace();
				}	
			}		
		}
		else
		{
		System.out.println(" action is null  ");
		}
	}
}