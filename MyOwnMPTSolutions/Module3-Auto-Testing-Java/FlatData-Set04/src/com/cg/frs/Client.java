package com.cg.frs;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;




public class Client {

	public static void main(String[] args) throws FlatException {
		PropertyConfigurator.
		configure("log4j.properties");
		Flat acc= new Flat();
		DataValidator validator= new DataValidator();
		DBHelper db= new DBHelper();
		
		System.out.println("1.Register Flat");
		System.out.println("2.Exit");
		Scanner sc= new Scanner(System.in);
		String rentAmt;
		
		boolean res;
		int ch= sc.nextInt();
		switch (ch)
		{
		case 1:
			
			System.out.println("Please Enter owner first name :");
			
			do{
				String firstName = sc.next();
				
				res= validator.validateData("^[A-Za-z]{2,}$",firstName);
				if( res==false){
					System.out.println("Please reEnter valid first Name ");
				}
				else{
					acc.setFirstName(firstName);
					break;
				}
				}while(res==false);
			
			System.out.println("Please Enter owner last name :");
			
			do{
				String lastName = sc.next();
				
				res= validator.validateData("^[A-Za-z]{2,}$",lastName);
				if( res==false){
					System.out.println("Please reEnter valid last Name ");
				}
				else{
					acc.setLastName(lastName);
					break;
				}
				}while(res==false);
			
			System.out.println("Please Enter mobile number : ");
			try {
				do{
					String MobileNo = sc.next();
					res= validator.validateData("^[0-9]{10}$",MobileNo);
					if( res==false){
						System.out.println("Please reEnter valid MobileNo ");
					}
					else{
						res =validator.MobileNo(Long.parseLong(MobileNo));
						if(res==true){
						acc.setMobileNo(Long.parseLong(MobileNo));
						break;
					}
						//else System.out.println("Price should be greater than 7000000000");
			
					}
					}while(res==false);
				
				
				System.out.println("Select Flat Type(1-1BHK,2-2BHK):");
				
				do{
					String FlatType = sc.next();
					res= validator.validateData("^[0-9]{1,}$",FlatType);
					if( res==false){
						System.out.println("Please reEnter valid FlatType ");
					}
					else{
						res =validator.FlatType(Integer.parseInt(FlatType));
						if(res==true){
						acc.setFlatType(Integer.parseInt(FlatType));
						break;
					}
						
					}
					}while(res==false);
				
				
				System.out.println("Enter desired rent amount Rs:");
				
				do{
					 rentAmt = sc.next();
					res= validator.validateData("^[0-9]{4,}$",rentAmt);
					if( res==false){
						System.out.println("Please reEnter valid rentAmt ");
					}
					else{
						res =validator.rentAmt(Double.parseDouble(rentAmt));
						if(res==true){
						acc.setRentAmt(Double.parseDouble(rentAmt));
						break;
					}
						else
							System.out.println("Price should be greater than 5000");
					
					}
					}while(res==false);
				
				
				System.out.println("Enter desired deposit amount Rs:");
				
				do{
					String depositAmt = sc.next();
					res= validator.validateData("^[0-9]{4,}$",depositAmt);
					if( res==false){
						System.out.println("Please reEnter valid depositAmt ");
					}
					else{
						res =validator.depositAmt(Double.parseDouble(depositAmt),Double.parseDouble(rentAmt));
						if(res==true){
						acc.setDepositAmt(Double.parseDouble(depositAmt));
						break;
					}
						else System.out.println("Deposit Amount  should be greater than rentAmount");
			
					
				}
				}while(res==false);
			
		}
			 catch(Exception e){
				System.out.println(e.getMessage());
			}
			try {
				long FlatId= db.insertFlat(acc);
				System.out.println("Flat with FlatID :<"+
				           FlatId+"> is registered ..");
			} catch (FlatException e) {
				System.out.println(e.getMessage());
			}break;
			
			case 2:
			{
				System.out.println("System Exit");
				System.exit(0);
				break;
			}
			
	}
}
}
	