package com.igate.demos;



public class SimpleLamda {

	public static void main(String[] args) {
	
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello from thread!");
			}
		};
		Runnable r2 = () -> {
			System.out.println("Hello from lambda!");
		};
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
