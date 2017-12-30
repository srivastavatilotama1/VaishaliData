package com.igate.demos;

public interface Area {

	public void calculateArea();
	
	public default double getPiConstantValue() {
		return 3.1415;
	}
	
	public static String getDescription() {
		return "This interface can be implemented by any shape to find area";
	}	
}
