/************Output**************
	Default format of LocalDate=2015-05-25
	25::May::2015
	20150525
	Default format of LocalDateTime=2015-05-25T11:08:46.097
	25::May::2015 11::08::46
	20150525
	Default format of Instant=2015-05-25T05:38:46.097Z
	Default format after parsing = 2014-04-27T21:39:48
 */
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
public class DateParseFormatExample {
 
    public static void main(String[] args) {
         
        //Format examples
        LocalDate date = LocalDate.now();
        //default format
        System.out.println("Default format of LocalDate="+date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
         
         
        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime="+dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
         
        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant="+timestamp);
         
        //Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing = "+dt);        
        System.out.println("d-m-u format"+date.format(DateTimeFormatter.ofPattern("d::MM::u")));
        System.out.println("d-m-uu format"+date.format(DateTimeFormatter.ofPattern("d::MM::uu")));
        System.out.println("d-m-uuuuu format"+date.format(DateTimeFormatter.ofPattern("d::MM::uuuu")));
        System.out.println("d-m-y format"+date.format(DateTimeFormatter.ofPattern("d::MM::y")));
        System.out.println("d-m-yy format"+date.format(DateTimeFormatter.ofPattern("d::MM::yy")));
        System.out.println("d-m-yyyy format"+date.format(DateTimeFormatter.ofPattern("d::MM::yyyy")));
    }
 
}
