package com.igate.trainee.exception;

public class TraineeException extends Exception{
	private String msg;
	public TraineeException()
	{
		
	}
	public TraineeException(String msg)
	{
		this.msg=msg;
	}
	
	public String getMessage()
	{
		return msg;
	}

}
