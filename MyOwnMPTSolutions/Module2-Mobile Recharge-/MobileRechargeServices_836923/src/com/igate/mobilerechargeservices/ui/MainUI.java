package com.igate.mobilerechargeservices.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.mobilerechargeservices.beans.Account;
import com.igate.mobilerechargeservices.exception.MobileServicesException;
import com.igate.mobilerechargeservices.service.AccountService;
import com.igate.mobilerechargeservices.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				

		String choice = null;
		String response = null ;
		
		Logger logger=Logger.getRootLogger();
		PropertyConfigurator.configure("resources//log4j.properties");
		AccountService accountService = new AccountServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
	
		do
		{
			System.out.println("Follow instruction to perform operation");
			System.out.println("______________________________________________________");
			System.out.println("Press 1 : Account Balance Enquiry");
			System.out.println("Press 2 : Recharge Account");
			System.out.println("press 3 : Exit");
			System.out.println("______________________________________________________");
		
			System.out.println("Enter your choice :");
			
			choice = scanner.nextLine();
			
			switch (choice) 
			{
				case "1":
					String accountId;
					Account account;
									
					System.out.println("Enter Account ID: ");
					accountId=scanner.nextLine();
					logger.info("Entered Account Id:"+accountId);
					try{	
					
						account=accountService.getAccount(accountId);
						
						System.out.println("Your Current Balance is RS. "+account.getAccountBalance());;
							
					}	
					catch(MobileServicesException exception)
					{
						logger.debug(exception.getMessage());
						logger.error(exception.getStackTrace());
						System.err.println(exception.getMessage());	
					}
					
				break;
		
				case "2":
					
					double rechargeAmt;
								
					System.out.println("Enter Account ID: ");
					accountId=scanner.nextLine();
					System.out.println("Enter Recharge Amt :");
					rechargeAmt=scanner.nextDouble();
					try{				
						if(accountService.rechargeAccount(accountId,rechargeAmt)==1)
						{	
							logger.info("Account Recharged Succesfully");
							System.out.println("Your Account Recharged Succesfully");
						}
						else
						{
							System.out.println("Do Not exist");
						}
					} 
						
					catch(MobileServicesException exception)
					{
						logger.debug(exception.getMessage());
						logger.error(exception.getStackTrace());
						System.err.println(exception.getMessage());	
					}
								
					
					
				break;
				
				case "3" :
					
					System.out.println("Application terminated");
					scanner.close();
					System.exit(0);
					
				
				default:
					System.out.println("Wrong data Input");
					break;
			}
		
		
		System.out.println("Do You Want To Continue .......");
		System.out.println("Press Yes To Continue ........ Any other key to exit");
		response = scanner.nextLine();
		response =response.toLowerCase();
		
	}while("yes".equals(response));
	System.out.println("Application terminated");
	scanner.close();
	System.exit(0);
}
		
		
		
	

}
