import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("*******From String To ArrayList***********");
		String str="Java,C,C++,DotNet";
		
		ArrayList<String> strL=new ArrayList();
		for(String tempStr:str.split(","))
		{
			strL.add(tempStr);
		}
		System.out.println(strL.size());
		System.out.println(strL);
		System.out.println("**********From Array List To String**********");
		String newString=new String();
		for (Iterator<String> it = strL.iterator() ; it.hasNext() ; )
		{
			  newString += it.next();
			  if (it.hasNext())
			  {				
			    newString += ","; 
			  }
		}
		System.out.println(newString);
		System.out.println("************From List To String ****");
		
		String newStringArray[]=strL.toArray
				(new String[strL.size()]);
		for(int i=0;i<newStringArray.length;i++)
		{
		System.out.println(newStringArray[i]);
		}

		char gen='M';
		String gender=new Character(gen).toString();
		System.out.println(gender);
		
	}

}
