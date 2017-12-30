import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TryIt
{
	public static void main(String args[]) 
	{
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println(strings.stream().filter((String string)->string.isEmpty()).count());
	}
} 
