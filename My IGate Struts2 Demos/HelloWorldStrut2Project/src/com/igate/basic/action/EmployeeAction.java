package com.igate.basic.action;

public class EmployeeAction 
{	
	String message;
	public String execute()
	{
	message = "Inside execute method";
	return "success";
	}
	public String add()
	{
	message = "Inside add method";
	return "displayAddEmp";
	}
	public String update()
	{
	message = "Inside update method";
	return "displayUpdateEmp";
	}
	
	public String delete()
	{
	message = "Inside delete method";
	return "displayDeleteEmp";

	}
	public String listAll()
	{
	message = "Inside listall method";
	return "listAllEmp";

	}
}
