
/********************************************************************************
 * File					:CustomerComplaintException.java
 * Author Name			:96121
 * Description			:User Defined Exception class
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.exception;

public class CustomerComplaintException extends RuntimeException
{

	public CustomerComplaintException() 
	{
		super();
	}

	
	public CustomerComplaintException(String message, Throwable e) 
	{
		super(message, e);
	}

	public CustomerComplaintException(String message) 
	{
		super(message);
	}

	public CustomerComplaintException(Throwable e)
	{
		super(e);
	}
	
}
