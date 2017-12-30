import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class TestSplitStringDemo {

	public static void main(String[] args) {
		
		//System.out.println("Vaishali".replaceAll("\\B", " "));
		
		try(Scanner sc=new Scanner(System.in)){;
		System.out.println( "Enter Name :");
		String name=sc.next();
		
		SplitString splitString1 = (String nm) -> nm.replaceAll("\\B", " ");
		System.out.println("Splitted Test is : "+splitString1.splitSpring(name));
		

		//Another way is 
		Supplier<String> supplier = () -> name;			
		Consumer<String> consumer = (String str)-> name.replaceAll("\\B", " ");			
		consumer.accept(supplier.get());
		}
		catch(Exception ee){}
			
	}
}

