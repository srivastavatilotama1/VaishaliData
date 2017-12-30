package com.ajax.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ajax.bean.Person;

public class InsertPersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	Person parr[]=new Person[50];
	static int index=0;
    public InsertPersonServlet() 
    {
        super();
        storeDetails();
    }
    public void storeDetails()
    {
    	parr[0]=new Person(822599, "yogini", "naik", "Pune");
    	parr[1]=new Person(12345, "Gikita", "Talsania", "Pune");
    	parr[2]=new Person(235333, "Shraddha", "Jadhav", "Pune");
    	parr[3]=new Person(121112, "Yukti", "Valecha", "Pune");
    	parr[4]=new Person(854123, "Vaishali", "Srivastava", "Pune");
    	
    }
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		JSONObject json= new JSONObject();
		String empid= request.getParameter("employeeId");
		System.out.println(empid);
		int id=Integer.parseInt(empid);
		PrintWriter out= response.getWriter();
		int i=0;
		try
		{
			for(i=0;i<5;i++)
			{
				if(parr[i].getEmpId()==id)
				{
					System.out.println("hello.....");
					json.put("FirstName", parr[i].getFirstName());
					json.put("LastName",parr[i].getLastName());
					json.put("location", parr[i].getLocation());
					break;
				}
			}
			if(i==5)
				json.put("ErrorMsg", "Record Not Found");
			
			out.println(json.toString());
		} 
		catch (JSONException e)
		{
			e.printStackTrace();
		}		
		}

}
