
import java.io.IOException; 
  public class Test5  
{
	public static void main(String[] args) 
	{
		try
		{
			throw new IOException();
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}	catch (IOException e)
		{
			System.out.println("Exception");
		}

}
}
