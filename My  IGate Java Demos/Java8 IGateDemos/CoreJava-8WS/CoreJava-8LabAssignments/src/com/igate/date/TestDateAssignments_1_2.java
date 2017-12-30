
package com.igate.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestDateAssignments_1_2
{

	public static void main(String[] args) 
	{
		 LocalDate today = LocalDate.now();
	        System.out.println("Current Date="+today);
	         
	        //Creating LocalDate by providing input arguments
	        LocalDate firstDay_2013 = LocalDate.of(2013, Month.JANUARY, 1);
	        Period period=Period.between(firstDay_2013, today);
	        System.out.println(" No Of Month  : "+period.getMonths());
	        System.out.println(" No Of Years  : "+period.getYears());
	        System.out.println(" No Of Days  : "+period.getDays());
	        System.out.println(" No Of Months Other Way  : "+period.toTotalMonths());
	        System.out.println("****** Enter UR Date Of Joining and Date Of Leaving***********");
	        try(Scanner sc=new Scanner(System.in);)
	        {
	        	System.out.println("Enter DOJ DD/MM/YYYY :");
	        	String DOJ=sc.next();
	        	System.out.println(" Date Of  Joining Is : "+DOJ);
	        	
	        	System.out.println("Enter Date Of Resign DD/MM/YYYY :");
	        	String DOL=sc.next();
	        	System.out.println(" Date Of Resign  Is : "+DOL);
	        	
	        	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        	
	        	LocalDate dojJ=LocalDate.parse(DOJ, dtf);
	        	LocalDate dojL=LocalDate.parse(DOL, dtf);
	        		        	
	        	Period  periodExep=Period.between(dojJ, dojL);
	        	
	        	System.out.println(" His Exep In Month : "+periodExep.toTotalMonths());
	        	System.out.println(" His Exep In Year : "+periodExep.getYears());
	        	 
	        }
	        catch(Exception ee)
	        {
	        	
	        }
	        
	        
	        
	       
	}

}
