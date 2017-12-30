import java.io.*;

public class CrypticCatch 
{ 
	public static void main(String[] args) throws Exception 
	{
		try 
		{ 
			try 
			{ 
				try 
				{ 
					throw new FileNotFoundException();
				} 
				catch(Exception e3)
				{ 
					System.out.println("E3*******************");
					throw e3;
				} 
			} catch(IOException e2)
			{ 
				System.out.println("E2*******************");
				throw e2;
			} 
		} 
		catch(FileNotFoundException e1) 
		{ 
			System.out.println("E1*******************");
			System.out.println("File not found exception caught");
		}
		System.out.println("Exception handled successfully"); 
	} 
}