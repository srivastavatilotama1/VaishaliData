package com.igate.controller;

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

import com.igate.dto.Employee;
import com.igate.exception.EmployeeException;
import com.igate.service.EmpServiceImpl;
import com.igate.service.IEmpService;

@WebServlet("/EmployeeController")

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	ServletConfig config;
	public EmployeeController() 
	{
		super();
		System.out.println(" Employee Controller  Constructor");
	}

	public void init(ServletConfig config) 
			throws ServletException
	{
		this.config=config;
		System.out.println(" Employee Controller  init function");
	}
	public void destroy() 
	{
		System.out.println("Employee Controller Destroy...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IEmpService empService=new EmpServiceImpl();
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();	
		if(action!=null)
		{
			if(action.equals("DisplayLoginPage"))
			{
				RequestDispatcher rd=
						request.getRequestDispatcher("/Pages/Login.jsp");				
				rd.forward(request, response);				

			}
			//*********End Of DisplayLoginPage************

			//******ValidateUser action***********

			if(action.equals("ValidateUser"))				
			{					
				RequestDispatcher rd=
						request.getRequestDispatcher
						("/Pages/ValidateLogin.jsp");
				rd.forward(request, response);				

			}
			//****** End Of ValidateUser action***********

			//Display Add Emp Page Action

			if(action.equals("DisplayAddEmpPage"))
			{
				int generatedEId=0;
				try 
				{
					generatedEId=empService.generateEmpId();
				} 
				catch(EmployeeException e) 
				{					
					e.printStackTrace();
				}	
				request.setAttribute("EmpId", generatedEId);
				RequestDispatcher rd=
						request.getRequestDispatcher
						("/Pages/AddEmp.jsp");
				rd.forward(request, response);
			}
			//Action for InsertEmp

			if(action.equals("InsertEmp"))
			{

				int eid=Integer.parseInt(
						request.getParameter("txtEId"));
				String ename=request.getParameter("txtEName");
				int sal=Integer.parseInt(request.getParameter
						("txtESal"));
				//create dto object
				Employee empDto=new Employee
						(eid, ename, sal);	

				//pass that empdto to service insert function.
				try
				{
					int inserted=empService.inserEmp(empDto);

					if(inserted==1)
					{
						RequestDispatcher rd=
								request.getRequestDispatcher
								("/Pages/EmployeeOperation.jsp");
						rd.forward(request, response);
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher
								("/Pages/ErrorPage.jsp");
						rd.forward(request, response);
					}
				} 
				catch (EmployeeException e) 
				{					
					e.printStackTrace();
				}				
			}
			//*******End of insert Emp Action	
			//*******List all Emp Action
			if(action.equals("ListAllEmp"))
			{

				try
				{
					ArrayList<Employee> empList=empService.
							getAllEmp();
					System.out.println(" list is .."+empList);
					request.setAttribute("EmpList", empList);
					RequestDispatcher rd=
							request.getRequestDispatcher
							("/Pages/ListAllEmp.jsp");
					rd.forward(request, response);
				} catch (EmployeeException e) 
				{					
					e.printStackTrace();
				}
			}
			// forward to Home
			
			if(action.equals("RedirectToHome"))
			{
				RequestDispatcher rd=
						request.getRequestDispatcher
						("/Html/EmpHome.html");
				rd.forward(request, response);
				
			}
		}
		else
		{
			out.print(" No Action Defined");
		}
	}

}
