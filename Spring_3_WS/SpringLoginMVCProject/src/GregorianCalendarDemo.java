import java.util.*;
public class GregorianCalendarDemo
   {    
		public static void main(String args[]) 
       {        
		Calendar calendar = new GregorianCalendar();   
		
		System.out.println("*********************");
		System.out.println("Todai is "+calendar.get(Calendar.YEAR)+":"	+			
		calendar.get(Calendar.MONTH)+":" +     
		calendar.get(Calendar.DAY_OF_MONTH));
		
		Date utilDate=new Date(1977,0,14);		
		System.out.println("Util date is : "+utilDate);
		System.out.println(" mm : "+utilDate.getMonth()+" :dd: "+utilDate.getDate()+
				":yyyy:"+utilDate.getYear());
			
		GregorianCalendar  calDate=new 
		GregorianCalendar(utilDate.getYear(),	utilDate.getMonth(),utilDate.getDate());
		System.out.println(" calDate :"+calDate);
		System.out.println(".."+calDate.get(Calendar.YEAR));       
		
		System.out.println(".."+calDate.get(Calendar.MONTH));      
		System.out.println(".."+calDate.get(Calendar.DAY_OF_MONTH));
		
		java.sql.Date sqlDate=new java.sql.Date(calDate.getTime().getTime());
		System.out.println("SQL Date is......."+sqlDate);
		//System.out.println(dd.getYear()+":"+ dd.getMonth()+":"+ dd.getDay());
		
		
		
		//Date ddgg=new Date(dd.getTime());
		//System.out.println(ddgg+"************");
			
       }
  }