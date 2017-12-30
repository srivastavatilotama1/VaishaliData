class TestString3 
{ 
	public static void main(String args[])
	{
		String s1 = "Hello"; 
		StringBuffer sb = new StringBuffer(s1);
		sb.reverse();
		System.out.println("Reverse   "+sb);
		String s3=s1.concat(sb.toString());
		System.out.println("s1**********   "+s3);
		System.out.println(s1 + sb + s1.length() + sb.length());
	} 
}