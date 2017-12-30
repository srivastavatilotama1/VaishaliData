package com.igate.sample;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class Client {

	private final static Logger logger = Logger.getLogger(Client.class);
	public static void main(String[] args) {
		logger.info("Application started.");
		Customer customer = null;
		DBHelper dbHelper = null;
		try(Scanner scanner = new Scanner(System.in)) {
			int choice=2;
			do {
				System.out.println("1.Add new customer data");
				System.out.println("2.Exit");
				System.out.println("==============================");
				System.out.print("Please enter your choice:");
				choice = scanner.nextInt();
				scanner.nextLine();
				switch(choice) {
				case 1: 
					System.out.print("Enter customer name:");
					String customerName = scanner.nextLine();
					if(!DataValidator.validateData("[A-Za-z ]{3,}", customerName)) {
						System.out.println("Invalid customer name! Please enter name atleast 3 chars long!");
						break;
					}
					System.out.print("Enter customer account type:1.PREPAID 2.POSTPAID:");
					int accountType = scanner.nextInt();
					if(accountType!=1 && accountType!=2){
						System.out.println("Invalid account type! Please enter valid type code!");
						break;
					}
					scanner.nextLine();
					System.out.print("Enter customer mobile:");
					String customerMobile = scanner.nextLine();
					if(!DataValidator.validateData("[0-9]{10}", customerMobile)) {
						System.out.println("Invalid customer mobile! Please enter valid 10 digit mobile!");
						break;
					}
					
					//data is valid
					customer  = new Customer();
					customer.setCustomerName(customerName);
					customer.setAccountType(accountType==1?"PREPAID":"POSTPAID");
					customer.setMobileNumber(customerMobile);
					
					dbHelper = new DBHelper();
					try {
						logger.info("Adding new customer details:"+customer.toString());
						customer  = dbHelper.addNewCustomer(customer);
						System.out.println("Your details successfully recorded with Customer id:"+customer.getCustomerId());
						logger.info("New customer details successfully recorded with Customer id:"+customer.getCustomerId());
					} catch (SampleException e) {
						System.out.println("Problem in adding customer details. Cause:"+e.getMessage());
						logger.error("Problem in adding customer details. Cause:"+e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid choice! Try again!");
					break;
				}
			}while(choice!=2);
		}
		logger.info("Application Exiting.");
		
	}
}
