import java.io.*;


class AA implements Serializable
{
	 transient int a = 7;
	  static int b = 9;
}

public class TestSerializable2 implements Serializable  
{
	
	public static void main(String... args)
	{
		AA a = new AA();
		try 
		{
		     ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.ser"));
		      os.writeObject(a);  
		      os. close();
		      System.out.print( + + a.b + " ");

		      ObjectInputStream is = new ObjectInputStream(new FileInputStream("test.ser"));
		      AA s2 = (AA)is.readObject();
		      is.close();
		      System.out.println(s2.a + "...." + AA.b);
		    }
			catch (Exception x) 
		    {
		    	x.printStackTrace();
		    }

	}

}