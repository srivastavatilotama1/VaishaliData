package com.cg.eis.exception;

public class EmployeeException extends Exception
{
	String msg;
	public EmployeeException(String msg)
	{
		super(msg);
	}

}
