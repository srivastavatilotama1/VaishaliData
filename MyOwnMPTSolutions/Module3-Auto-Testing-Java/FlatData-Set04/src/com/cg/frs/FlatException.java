package com.cg.frs;

public class FlatException extends Exception {

			private String message;
			public  FlatException(){
			
			}
			public  FlatException(String error){
				message=error;
			}
			public void printError(){
				System.out.println(message);
			}
		}

