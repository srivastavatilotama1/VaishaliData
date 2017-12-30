
//create a java docs by using the coomand  c:>javadoc Test_Annotations.java

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
 @interface Retention_Demo 
{
	String doRetentionDemo();
}


@Documented
 @interface Documented_Demo 
{
	String doTestDocumentedDemo();
}

//Next, make changes in Test_Annotations class as follows:

public class Test_Annotations
{
	public static void main(String arg[]) 
	{
		new Test_Annotations().doTestRetentionDemo();
		new Test_Annotations().doTestDocumentedDemo();
	}
	@Retention_Demo (doRetentionDemo="Hello retention annotation")
	public void doTestRetentionDemo()
	{
		System.out.printf("Testing 'Retention' annotation");
	}
	@Documented_Demo (doTestDocumentedDemo="Hello Test documentation")
	public void doTestDocumentedDemo() 
	{
		System.out.printf("Testing 'Documented' annotation");
	}
}

