class TestString2
{ 
	public static void main(String args[])
	{ 
		String s1 = "Test1"; 
		String s2 = "Test2";
		s1.concat(s2);
		System.out.println(""+s1.charAt(s1.length() - 3) + s1.indexOf(s2));
		}
	}
