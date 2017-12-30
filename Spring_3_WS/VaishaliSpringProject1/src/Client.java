import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igate.bean.Student;

public class Client 
{	
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Student s1=context.getBean("s1",Student.class);
		System.out.println(s1);
	
		Student s2=context.getBean("s2",Student.class);
		System.out.println(s2);
	
	
	}
	

}
