package com.igate.demos;

public class TestClass {

	public static void main(String[] args) {
		MaxFinder finder = (num1,num2) -> num1>num2?num1:num2;
		int result = finder.maximum(10, 20);
		System.out.println(result);
	}
}
