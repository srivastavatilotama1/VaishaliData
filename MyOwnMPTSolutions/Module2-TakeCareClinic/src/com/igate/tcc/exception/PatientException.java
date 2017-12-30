package com.igate.tcc.exception;

public class PatientException extends Exception 
{
	String message;

	public PatientException(String message) {
		super(message);
		this.message = message;
	}
	
}
