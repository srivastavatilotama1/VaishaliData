package com.igate.operations;

public class SubOps implements Operation
 {
	public int op(int a, int b) 
	{
		return a-b;
	}
	public String getDesc() 
	{
		return "minus";
	}
}