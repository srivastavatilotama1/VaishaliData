class CheckedException extends RuntimeException
{ } 
class UncheckedException extends Exception 
{ } 
public class Check 
{
	public static void main(String args[]) 
	{
		generateException1(); 
		generateException2();
	}
	private static void generateException1()
	{ 
		throw new CheckedException(); 
	} 
	private static void generateException2() 
	{ 
		throw new UncheckedException(); 
	}
} 