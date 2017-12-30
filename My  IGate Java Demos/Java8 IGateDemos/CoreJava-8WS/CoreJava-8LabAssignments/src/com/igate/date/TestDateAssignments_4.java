/* LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);
         
        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
 * 
 */
package com.igate.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

public class TestDateAssignments_4
{

	public static void main(String[] args) 
	{
		    System.out.println("****** Zone List Is :***********");
	        try(Scanner sc=new Scanner(System.in);)
	        {
	        	Set<String> zoneIdList=
				ZoneId.getAvailableZoneIds();
	        	System.out.println(zoneIdList);
	        	int i=0;
	        	for(String zoneName:zoneIdList)
	        	{
	        		System.out.println(i++ +"  :   "+zoneName);	        		
	        	}
	        	
	        	System.out.println("Enter Zone Id :");
	        	int zoneId= sc.nextInt();
	        	String zoneName=null;
	        	int j=0;
	        	for(String zoneNameTemp:zoneIdList)
	        	{
	        		int index=j++;
	        		if(zoneId==index)   
	        		{
	        			zoneName=zoneNameTemp;
	        			break;
	        		}	        		
	        	}
	        	System.out.println(" You Zone Name  is : "+zoneName);    	
	        	
	        	 LocalDateTime yourZoneDate = LocalDateTime.now(ZoneId.of(zoneName));
	             System.out.println("Current Date in IST with Respect To UR Zone Is :"+yourZoneDate);   	            
	        	 
	        }
	        catch(Exception ee)  { 	ee.printStackTrace();       }  	       
	}
}
