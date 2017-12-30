/**
 * @author vivek
 * 
 */

public class OverrideInterface implements IOverrideInterface
{
	@Override
	public void display() 
	{
		System.out.println("Display Method");
	}

	@Override
	public void show() 
	{
		System.out.println("Show Method");	
	}
}
