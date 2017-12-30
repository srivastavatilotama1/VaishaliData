package com.cg.eis.ctrl;

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

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmpServiceImpl;
import com.cg.eis.service.IEmpService;

//@WebServlet("/EmployeeController")
@WebServlet("*.do")
public class EmployeeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
   
    public EmployeeController() { super();   }
	public void init(ServletConfig config) throws ServletException
	{super.init(config);}	
	public void destroy()
	{}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		IEmpService empService=new EmpServiceImpl();
		String path=request.getServletPath();
		System.out.println("Path********"+path);
		switch(path)
		{
			case "/ShowAddEmpPage.do":
					RequestDispatcher rd1=request.
					getRequestDispatcher("/Pages/AddEmp.jsp");
					rd1.forward(request, response);
					break;
			case "/AddEmp.do":
					int eid=Integer.parseInt(request.getParameter("txtEmpId"));
					String enm=request.getParameter("txtEmpName");
					
					Employee ee=new Employee(eid,enm);
					try 
					{
						int dataAdded=empService.addEmployee(ee);
						if(dataAdded==1)
						{
							ArrayList<Employee> eList=empService.getAllEmp();
							request.setAttribute("EmpList", eList);
							RequestDispatcher rdSuccess=request.
									getRequestDispatcher("/Pages/ListAllEmp.jsp");
							rdSuccess.forward(request, response);
						}
						else
						{
							RequestDispatcher rdFailure=request.
									getRequestDispatcher("/Pages/ErrorEmp.jsp");
							rdFailure.forward(request, response);
							
						}
					}
					catch (EmployeeException e)
					{					
						e.printStackTrace();
					}
					
					break;
			default: 
					PrintWriter out=response.getWriter();
					out.print("No Action Defined");
			
		
		}
		
	}

}
