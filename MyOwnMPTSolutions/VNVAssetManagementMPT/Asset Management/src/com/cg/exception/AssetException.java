/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To define exceptions for invalid input

package com.cg.exception;

public class AssetException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public AssetException()
	{
		super();
	}
	public AssetException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AssetException(String message, Throwable cause) 
	{
		super(message, cause);
	}
	public AssetException(String message) 
	{
		super(message);			
	}
	public AssetException(Throwable cause) 
	{
		super(cause);			
	}
}

