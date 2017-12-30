/*
 * ************Stream API Using Java 8: **********************
********filter******************
************Stream API Using Java 8: **********************
********filter******************
Original   Int List: [11, 3, 44, 5, 66, 33, 44]
1144663344**************distict**************
Original List  : [AA, AA, BB]
Number of distinct element:2
*****Distinct Using foreach********
Original : [11, 3, 44, 5, 66, 33, 44]
11
3
44
5
66
33
************Limit******************
Original : [11, 3, 44, 5, 66, 33, 44]
First 4 elements  : 
11
3
44
5
***********Length Of Each Word using map*******************
Original  wordsList: [IGATE, GLOBAL, SOLUTIONS]
5
6
9
********Empty String Count **********************
Original Strings : [abc, , bc, efg, abcd, , jkl]
Empty Strings Count Is : 2
********String With Length 3****************
Original Strings : [abc, , bc, efg, abcd, , jkl]
Strings of length 3: 3
********Non Empty String List****************
Original Strings : [abc, , bc, efg, abcd, , jkl]
Filtered  Non Empty List: [abc, bc, efg, abcd, jkl]
*****Merged Non Empty String Using Comma *************
Original Strings : [abc, , bc, efg, abcd, , jkl]
Merged Non Empty String Using Comma : abc,bc,efg,abcd,jkl
********Number List With square****************
Original numberes : [3, 2, 2, 3, 7, 3, 5]
Squares List: [9, 4, 49, 25]
********Use Of IntSummerStatistic**************
Original Integer List: [1, 2, 13, 4, 15, 6, 17, 8, 19]
Highest number in List : 19
Lowest  number in List : 1
Sum of all numbers : 85
Average of all  numbers : 9.444444444444445
**********Random Numbers:*********************** 
-2084717139
-1670905023
-1581655105
-1537215599
-1378156139
-914507298
-730747183
1041478155
1081412895
1679707721
**********parallel processing****************** 
Original Strings : [abc, , bc, efg, abcd, , jkl]
Empty Strings: 2
*********************Concat**************
[a, b, c, d, e, f, g]
***********collect************
12:Samir, 16:Vaishali
******Collect method other way round********
21:Ola Hansen, 30:Nikhil, 45:Vishal, 89:Karthik
***********stream reduce function************
Result:24

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamAPIDemo_8 {

	public static void main(String[] args) 
	{	
		System.out.println("************Stream API Using Java 8: **********************");
	
		System.out.println("********filter******************");
		List<Integer>  listInt1 = Arrays.asList(11,3,44,5,66,33,44);
		System.out.println("Original   Int List: "+listInt1);
		listInt1.stream().filter(num -> num > 10).forEach(num->System.out.print(num));

		System.out.println("**************distict**************");
		List<String> list = Arrays.asList("AA","AA","BB");
		System.out.println("Original List  : "+list);
		Stream  listDistinct=list.stream().distinct();
		long distictCount = listDistinct.count();
		System.out.println("Number of distinct element:"+distictCount);

		System.out.println("*****Distinct Using foreach********");

		List<Integer>  listInt2 = Arrays.asList(11,3,44,5,66,33,44);
		System.out.println("Original : "+listInt2);
		listInt2.stream().distinct().forEach(System.out :: println);

		System.out.println("************Limit******************");
		List<Integer>  listInt3 = Arrays.asList(11,3,44,5,66,33,44);
		System.out.println("Original : "+listInt3);
		System.out.println("First 4 elements  : ");
		listInt3.stream().limit(4).forEach(System.out :: println);
		
		System.out.println("***********Length Of Each Word using map*******************");

		List<String> wordsList = Arrays.asList("IGATE","GLOBAL","SOLUTIONS");
		System.out.println("Original  wordsList: "+wordsList);		
				
		Stream<Object> wordsListStream=wordsList.stream().map(str->str.length());
		wordsListStream.forEach(System.out :: println);
		//wordsList.stream().map(str->str.length()).forEach(System.out :: println);
		
		
		System.out.println("********Empty String Count **********************");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("Original Strings : " +strings);
		Stream<String> strmS=strings.stream();
		Predicate<String> predicate=(String string)->string.isEmpty();
		Stream strmD=strmS.filter(predicate);
		long count = strmD.count();
		System.out.println("Empty Strings Count Is : " + count);

		
		System.out.println("********String With Length 3****************");
		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("Original Strings : " +strings);
		System.out.println("Strings of length 3: " + count);

		
		System.out.println("********Non Empty String List****************");
		System.out.println("Original Strings : " +strings);
		
		Stream<String> nonEmptyFilteredList=strings.stream().filter(string -> !string.isEmpty());
		/*
			Returns a Collector that accumulates the input elements into a new List.
		 	There are no guarantees on the type, mutability, serializability, or 
		 	thread-safety of the List returned; if more control over the returned List is required,
		  	use toCollection(Supplier).
			Parameters:
					<T> the type of the input elements
			Returns:
					a Collector which collects all the input elements into a List, 					
				in encounter order*/
		List<String>  newNonEmptyList=nonEmptyFilteredList.collect(Collectors.toList());
		
		//List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).
			//	collect(Collectors.toList());
		System.out.println("Filtered  Non Empty List: " + newNonEmptyList);

		System.out.println("*****Merged Non Empty String Using Comma *************");
		System.out.println("Original Strings : " +strings);
		/*
		 * Returns a Collector that concatenates the input elements, 
		 * separated by the specified delimiter, in encounter order.
			Parameters:
					delimiter the delimiter to be used between each element
			Returns:
				A Collector which concatenates CharSequence elements, 
				separated by the specified delimiter, in encounter order		  
		 */
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).
				collect(Collectors.joining(","));
		System.out.println("Merged Non Empty String Using Comma : " + mergedString);

		System.out.println("********Number List With square****************");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);		
		System.out.println("Original numberes : " +numbers);
		Stream<Integer> squareStream=numbers.stream().map( i -> i*i);
		Stream<Integer> squareDistStream=squareStream.distinct();
		List<Integer> squaresList=squareDistStream.collect(Collectors.toList());	
		System.out.println("Squares List: " + squaresList);	   

		System.out.println("********Use Of IntSummerStatistic**************");
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		System.out.println("Original Integer List: " +integers);
		Stream<Integer> integerStream=integers.stream();
		/* Returns an IntStream consisting of the results of applying the 
		 * given function to the elements of this stream. 
				This is an intermediate operation.
			Parameters:
					mapper a non-interfering, stateless function to apply to each element
			Returns:
					the new stream		 
		 */
		IntStream   integerMapStream=integerStream.mapToInt((x) -> x);
		
		//IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		/* Returns an IntSummaryStatistics describing various summary data
		 *  about the elements of this stream. This is a special case of a reduction. 
			This is a terminal operation.
			Returns:
					an IntSummaryStatistics describing various summary data about the elements of this stream
		 */
		IntSummaryStatistics stats=integerMapStream.summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest  number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all  numbers : " + stats.getAverage());
		System.out.println("**********Random Numbers:*********************** ");
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);

		//parallel processing
		System.out.println("**********parallel processing****************** ");
		System.out.println("Original Strings : " +strings);
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);

		System.out.println("*********************Concat**************");
		String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "e", "f", "g" };
		Stream<String> stream1 = Stream.of(arr1);
		Stream<String> stream2 = Stream.of(arr2);

		Stream<String> stream3 = Stream.concat(stream1, stream2);
		String[] arr = stream3.toArray(String[]::new);
		System.out.println(Arrays.toString(arr));

		System.out.println("***********collect************");
		//Data
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Ola Hansen", 21));
		persons.add(new Person("Karthik", 89));
		persons.add(new Person("Samir", 12));
		persons.add(new Person("Vaishali", 16));
		persons.add(new Person("Vishal", 45));
		persons.add(new Person("Nikhil", 30));

		//Solution
		String names = persons.stream()
				.filter(p -> p.getAge() < 18)
				.sorted((p1, p2) -> p1.getAge() - p2.getAge())
				.map(p -> p.getAge() + ":" + p.getName())
				.collect(Collectors.joining(", "));

		System.out.println(names);
		System.out.println("******Collect method other way round********");
		List<Person> persons2 = new ArrayList<>();
		persons2.add(new Person("Ola Hansen", 21));
		persons2.add(new Person("Karthik", 89));
		persons2.add(new Person("Samir", 12));
		persons2.add(new Person("Vaishali", 16));
		persons2.add(new Person("Vishal", 45));
		persons2.add(new Person("Nikhil", 30));

		Stream<Person> strmOriginalPerson=persons2.stream();
		Predicate<Person> predicateAdult=(Person per)->per.getAge() > 18;
		Stream<Person> streamAdult=strmOriginalPerson.filter(predicateAdult);
		Stream <Person>streamSorted=streamAdult.sorted((p1, p2) -> p1.getAge() - p2.getAge());//para pass in sorted is comparator

		Stream streamMapped =streamSorted.map(p -> p.getAge() + ":" + p.getName());
		String namesAdults=(String)streamMapped.collect(Collectors.joining(", "));
		System.out.println(namesAdults);
		System.out.println("***********stream reduce function************");

		List<Integer> intList = Arrays.asList(5,7,3,9);
		Optional<Integer> result = intList.stream().reduce((a,b)->a+b);
		if(result.isPresent()) 
		{
			System.out.println("Result:"+result.get());
		}	
}
}
