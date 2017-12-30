

import java.util.function.Function;



public class TestFactorial4 {

	public static void main(String[] args) {
		
		IFactorial factObj=new FactorialImpl();
		Function<Integer,Integer> funcRef = factObj::calcFact1;
		System.out.println("Factorial is  :"+funcRef.apply(4));
		
		
	}
}
