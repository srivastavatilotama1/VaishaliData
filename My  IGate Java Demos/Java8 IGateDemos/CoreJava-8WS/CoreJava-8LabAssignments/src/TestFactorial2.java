import java.util.function.Function;


public class TestFactorial2
{
	public static void main(String[] args) 
	{
		Function<Integer,FactorialImpl> factFunction = (Integer number)->FactorialImpl.createFactorialImpl(number);
		FactorialImpl obj=factFunction.apply(7);
		System.out.println("Factorial is : "+obj.calcFact2());
	}

}
