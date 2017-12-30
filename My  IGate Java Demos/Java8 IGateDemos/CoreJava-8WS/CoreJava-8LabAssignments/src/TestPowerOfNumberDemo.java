import java.util.Scanner;


public class TestPowerOfNumberDemo 
{
	public static void main(String args[])
	{
		PowerOfNumber powerOfNumnber=(int x,int y)->{return (int)(Math.pow((double)x,(double)y));};
		Scanner sc=new Scanner(System.in);
		System.out.println( "Enter X :");
		int x=sc.nextInt();
				
		System.out.println( "Enter Y :");
		int y=sc.nextInt();
		System.out.println(x+ " Raise To Power  "+y + "  Is : "+powerOfNumnber.getPower(x, y));
	}

}
