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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

public class TestDateAssignments_5
{

	public static void main(String[] args) 
	{
		System.out.println("****Zone List :********");
		try(Scanner sc=new Scanner(System.in);)
		{
			Set<String> zoneIdList=ZoneId.getAvailableZoneIds();
			TreeSet<String> soretedZoneList=new TreeSet<String>(zoneIdList);
			System.out.println(new TreeSet<String>(zoneIdList));
			int i=0; 

			for(String zoneName:soretedZoneList)
			{
				System.out.println(i++ +"  :   "+zoneName);	        		
			}
			System.out.println("****************276***************************");
			System.out.println("Enter Departure Zone  Id  :  276  ");	       
			int zoneDeptId= sc.nextInt();
			String deptZoneName=null;
			int j=0;
			for(String zoneNameTemp:soretedZoneList)
			{
				int index=j++;
				if(zoneDeptId==index)   
				{
					deptZoneName=zoneNameTemp;
					break;
				}	        		
			}
			System.out.println(" You  Departure Zone Name  is : "+deptZoneName);   
			System.out.println("***********************************************");
			System.out.println("Enter Departure Date in  dd-MMM-yyyy:HH:mm  format ");
			String dateOfDepartureText=sc.next();		
			DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm");
			LocalDateTime 	dateOfDeparture=LocalDateTime.parse(dateOfDepartureText, dateFormat);
			System.out.println("************Enter Travel Time in Hours mints***************");  
			int arrivalHours=sc.nextInt();
			System.out.print(" : ");
			int arrivalMinutes=sc.nextInt();
			System.out.println(" Arrival  Time In Hours And Minutes: "+arrivalHours +" : "+arrivalMinutes);
			System.out.println("***********************************************");  
			System.out.println("Enter Arrival Zone  Id  :  167  ");	       
			int zoneArrivalId= sc.nextInt();
			String arrivalZoneName=null;
			j=0;
			for(String zoneNameTemp:soretedZoneList)
			{
				int index=j++;
				if(zoneArrivalId==index)   
				{
					arrivalZoneName=zoneNameTemp;
					break;
				}	        		
			}
			System.out.println(" You  Arrival Zone Name  is : "+arrivalZoneName);  
			LocalDateTime arrivalDateAfterHours=dateOfDeparture.plusHours(arrivalHours);
			LocalDateTime arrivalDateAfterMints=arrivalDateAfterHours.plusMinutes(arrivalMinutes)   ;			
						ZonedDateTime arrivalZoneDateTime = ZonedDateTime.of(arrivalDateAfterMints,ZoneId.of(deptZoneName));			
			System.out.println("Arrival Date Time " +arrivalZoneDateTime.withZoneSameInstant(ZoneId.of(arrivalZoneName)));	
		}
		catch(Exception ee)  { 	ee.printStackTrace();}  	       
	}
}

