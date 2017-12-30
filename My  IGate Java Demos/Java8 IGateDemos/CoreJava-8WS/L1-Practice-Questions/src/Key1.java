public class Key1
{ 
	public boolean testAns( String ans, int n )
	{ 
		boolean rslt=false;
		if (ans.equalsIgnoreCase("YES") & n > 5) 
			rslt = true; 
		return rslt; 
	} 
	public static void main(String args[])
	{ 
		System.out.println(new Key1().testAns("no", 5));
	} 
}
