 abstract class  AAA
{
	 public AAA()
	 {
		 System.out.println("In constructor Of A");
	 }
	public abstract  void show();
	
	public void get()
	{
		System.out.println("In get");
	}	
}
 class BB extends AAA
 {	
	public void show()
	{
		System.out.println("In show Of B");
	}
	public void get()
	{
		System.out.println("In get Of B");
	} }

public class TestAbstractDemo 
{
	public static void main(String[] args) 
	{
		AAA a1=new BB();
		a1.get();
	}
}
