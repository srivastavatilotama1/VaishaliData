import java.io.*; 
public class SteppedTryCatch 
{ 
	public static void main(String[] args) 
	{ 
		try
		{ 
			try 
			{ 
				try 
				{ 
					throw new Exception();
				} 
				catch(Exception e3) 
				{ 
					System.out.println("Exception 1");
					// Line 2 
					throw new IOException();
				} 
			} 
			catch(IOException e2) 
			{ 
				System.out.println("Exception 2");
				// Line 3 
				throw new FileNotFoundException();
			}
		} 
		catch(FileNotFoundException e1) 
		{
			System.out.println("Exception 3"); 
		} 
	} 
}
