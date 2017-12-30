package com.capgemini.salesmanagement.exception;

public class ProductException extends Exception
{
	String msg;
	public ProductException(String msg)
	{
		super(msg);
	}
}
