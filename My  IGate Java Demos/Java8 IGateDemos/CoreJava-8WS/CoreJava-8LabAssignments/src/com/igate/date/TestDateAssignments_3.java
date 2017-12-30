/* LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);
         
        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
 * 
 */
package com.igate.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestDateAssignments_3
{

	public static void main(String[] args) 
	{
		    try(Scanner sc=new Scanner(System.in);)
	        {
	        	System.out.println("Enter Product Purchase dd-MMM-yyyy :");
	        	String dateOfPurchase=sc.next();
	        	System.out.println(" Date Of  Product Purchase Is : "+dateOfPurchase);
	        	
	        	System.out.print("Enter Period In Terms of Month And Year :  Year : Months");
	        	int years=sc.nextInt();
	        	System.out.print(" : ");
	        	int months=sc.nextInt();
	        	System.out.println(" Warrenty In Year and Month  : "+years +" : "+months);
	        	
	        	DateTimeFormatter dateTimeFormatter1=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	        		        	
	        	LocalDate dateOfPurchaseD=LocalDate.parse(dateOfPurchase, dateTimeFormatter1);
	        	LocalDate oneYearAfterPurchaDate=dateOfPurchaseD.plusYears(years);
	        	LocalDate lastWarrentDate=oneYearAfterPurchaDate.plusMonths(months)   ;    	
	       
	        	System.out.println(" UR Purchase Date is :"+dateOfPurchaseD);
	        	System.out.println(" Last Wanrrenty date Is : "+lastWarrentDate);
	        	 
	        }
	        catch(Exception ee)
	        {
	        	ee.printStackTrace();
	        }
	        
	        
	        
	       
	}

}
