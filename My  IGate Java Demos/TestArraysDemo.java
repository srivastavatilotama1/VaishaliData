import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class TestArrayDemo {


	public static void main(String[] args) {
		
		Integer i1=new Integer(4);
		Integer i2=new Integer(5);
		Integer i3=new Integer(2);
		Integer i4=new Integer(1);
		
		int i[]=new int[3];
		Integer objectA[][]=new Integer[2][2];
		objectA[0][0]=i1;
		objectA[0][1]=i2;
		objectA[1][0]=i3;
		objectA[1][0]=i4;
		
		System.out.println(objectA[0][1]);
		
		List<Integer[]> col=Arrays.asList(objectA);
		// Iterator it=col.iterator();
		// it.hasNext();
		 //	 Integer tempObj=(Integer)it.next();
		 System.out.println(col.get(0)[1]);
		 
		
		 //2-dimensional array is an array of arrays...   
	    String[][] myStrings = { {"abc", "def"}, {"ghi", "jkl"} };   
	       
	    //so the list holds single-dimension String arrays...   
	    List<String[]> list = Arrays.asList(myStrings);   
	    System.out.println(list.get(0)[1]); 

	}

}
