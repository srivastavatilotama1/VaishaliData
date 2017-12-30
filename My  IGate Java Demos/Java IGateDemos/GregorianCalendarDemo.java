import java.util.*;
public class GregorianCalendarDemo
   {    
		public static void main(String args[]) 
       {        
		Calendar calendar = new GregorianCalendar();   
		System.out.println("*********************");
		System.out.println(calendar.get(Calendar.YEAR));       
		System.out.println(calendar.get(Calendar.MONTH+1));      
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		GregorianCalendar newcal=new GregorianCalendar(1990, 3, 23);
		java.sql.Date dd=new java.sql.Date(((newcal.getTime()).getTime()));
		System.out.println("......."+dd);
		
		System.out.printf("%s\n",17);
			
       }
  }