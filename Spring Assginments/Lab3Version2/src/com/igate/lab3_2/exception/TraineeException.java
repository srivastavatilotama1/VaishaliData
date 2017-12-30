package com.igate.lab3_2.exception;

public class TraineeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public TraineeException(String message){
		this.message=message;
	}
	public String getMessage(){
		return message;
	}
}
