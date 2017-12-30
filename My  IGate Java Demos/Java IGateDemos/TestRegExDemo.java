import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestRegExDemo
{	
	public static void main(String[] args) 
	{
		String inputStr1 = "Test String";
		String pattern1 = "Test String";
		boolean patternMatched1 = 
			Pattern.matches(pattern1, inputStr1);           
		System.out.println(patternMatched1);

		System.out.println("******match character*******");
		String empname="Vaishali";

		String pattern2="[A-Z][a-z]{0,19}";
		if(Pattern.matches(pattern2, empname))
		{
			System.out.println(" Pattern match");			
		}
		else
		{
			System.out.println
			(" Employee  name should start with capital and max length is 20");

		}	

		System.out.println("******************");

		String mn="9999999999";
		String pattern3="[0-9]{10}";
		if(Pattern.matches(pattern3, mn))
		{
			System.out.println("Mo bile matched");
		}
		else
		{
			System.out.println("Mobiler no should be min 10 digits");
		}
		System.out.println("*********Match email address");
		String email="vaishali.men@gmail.co.in";
		String pattern4 = 
			"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*"+
			"@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"+
			"(\\.[A-Za-z]{2,})$"; 		 
		if(Pattern.matches(pattern4, email))
		{
			System.out.println("valid email");
		}
		else
		{
			System.out.println("invalid email");
		}
		System.out.println("*****Group method**********");
	
		System.out.println("*************");
		String input = "Shop,Mop,Hopping,Chopping";
		Pattern pattern = Pattern.compile("hop");
		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.matches());
		while (matcher.find())
		{
		    System.out.println(matcher.group() +
		    		": " +matcher.start() + 
		    		": " + matcher.end());
		}
	}
}