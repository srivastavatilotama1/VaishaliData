/* ************output************
 	Year 2015 is Leap Year? false
		Today is before 01/01/2015? false
		Current Time=2015-05-25T11:01:28.590
		10 days after today will be 2015-06-04
		3 weeks after today will be 2015-06-15
		20 months after today will be 2017-01-25
		10 days before today will be 2015-05-15
		3 weeks before today will be 2015-05-04
		20 months before today will be 2013-09-25
		First date of this month= 2015-05-01
		Last date of this year= 2015-12-31
		Period Format= P7M6D
		Months remaining in the year= 7
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
 
public class DateAPIUtilities {
 
    public static void main(String[] args) {
         
        LocalDate today = LocalDate.now();
         
        //Get the Year, check if it's leap year
        System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());
         
        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? "+today.isBefore(LocalDate.of(2015,1,1)));
         
        //Create LocalDateTime from LocalDate
        System.out.println("Current Time="+today.atTime(LocalTime.now()));
         
        //plus and minus operations
        System.out.println("10 days after today will be "+today.plusDays(10));
        System.out.println("3 weeks after today will be "+today.plusWeeks(3));
        System.out.println("20 months after today will be "+today.plusMonths(20));
        System.out.println("20 months after today will be "+today.plusMonths(20));
 
        System.out.println("10 days before today will be "+today.minusDays(10));
        System.out.println("3 weeks before today will be "+today.minusWeeks(3));
        System.out.println("20 months before today will be "+today.minusMonths(20));
         
        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= "+lastDayOfYear);
         
        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= "+period);
        System.out.println("Months remaining in the year= "+period.getMonths());
       Period per= Period.between(LocalDate.of(2015,1,1),today );
       System.out.println(per.getMonths());
       System.out.println(" Enter Day ");
				
		System.out.println("  .............."+DayOfWeek.valueOf("friday"));
		
		
      
    }
}
