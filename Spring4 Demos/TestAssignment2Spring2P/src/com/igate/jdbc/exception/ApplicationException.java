package com.igate.jdbc.exception;

public class ApplicationException extends Exception
{
	String msg;public ApplicationException(String msg)
	{
		super(msg);
	}

}
