
public class TestMaxFinderLambdaDemo {

	public static void main(String[] args)
	{
		MaxFinder finder = new MaxFinderImpl();
		int result = finder.maximum(190, 20);
		System.out.println("Greatest Is  :"+result);

			//same thing without functional interface 
		//implementation is done using lamda expression.
		
		MaxFinder finder2 = (num1,num2) -> num1>num2?num1:num2;
		int result2 = finder.maximum(10, 20);
		System.out.println("Greatest Is  :"+result2);

	}

}
