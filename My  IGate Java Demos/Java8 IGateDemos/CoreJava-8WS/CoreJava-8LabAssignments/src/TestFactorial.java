import java.util.function.Consumer;
import java.util.function.Function;


public class TestFactorial
{
	public static void main(String[] args) 
	{
		Function<Integer,FactorialImpl> factFunction = 
				new Function<Integer,FactorialImpl>()
		{
				public FactorialImpl apply(Integer number)
				{
					  return new FactorialImpl(number);
				}				
		};
		
		FactorialImpl obj=factFunction.apply(6);
		System.out.println("Fact is "+obj.calcFact2());
		
		//other syntax............
				
		//Consumer<Integer> consumer2 = IFactorial :: calcFact1;
		//consumer2.accept(4);
	}

}
