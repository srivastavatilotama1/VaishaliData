import java.util.function.Function;


public class TestFactorial3
{
	public static void main(String[] args) 
	{
		Function<Integer,FactorialImpl> factFunction = FactorialImpl::createFactorialImpl;
		FactorialImpl obj=factFunction.apply(7);
		System.out.println("Factorial is : "+obj.calcFact2());
	}

}
