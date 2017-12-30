package com.igate.DemoMVC.exception;


public class UserException extends Exception {
	
	String message;

	public UserException(String message) {
		super();
		this.message = message;
	}
	

}