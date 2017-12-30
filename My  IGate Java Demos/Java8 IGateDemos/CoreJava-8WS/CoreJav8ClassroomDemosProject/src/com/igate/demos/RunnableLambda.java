package com.igate.demos;

public class RunnableLambda {

	public static void main(String[] args) {
		
		Runnable run = ()-> System.out.println("Hello from thread");
		new Thread(run).start();
	}
}