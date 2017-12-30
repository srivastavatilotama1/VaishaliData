import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterface 
{
	public static void main(String args[])
	{
		Consumer<String> consumer = (String str)-> System.out.println(str);
		consumer.accept("Hello LE!");
		
		Supplier<String> supplier = () -> "Hello from Supplier!";
		consumer.accept(supplier.get());
		
		//even number test
		Predicate<Integer> predicate = num -> num%2==0;
		System.out.println(" Is Even ?"+predicate.test(24));
		System.out.println(" Is Even ?"+predicate.test(15));
		
		//max test
		BiFunction<Integer, Integer, Integer> maxFunction = (x,y)->x>y?x:y;
		System.out.println(maxFunction.apply(25, 14));

		BinaryOperator<Integer> maxFunction2 = (x,y) -> x>y?x:y;
		System.out.println(maxFunction2.apply(45, 5));
		
		
		//Method References 
		
		Consumer<String> consumer2 = System.out :: println;
		consumer2.accept("Hello IGattors using Method Reference Lmda Expression!");



	}
}
