
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import com.igate.bean.Student;
import com.igate.service.StudentService;

public class Client 
{	
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		StudentService stuSer=context.getBean("studentService",StudentService.class);
	
		try
		{
		int res1=stuSer.addStudent(new Student (222,"gitika",2000.0f));
		System.out.println(" Added "+res1);
		}
		catch(DuplicateKeyException de)
		{
			System.out.println("duplicate roll no.");
		}
	/*	System.out.println(" *************Delete *****************");
	*
		try
		{
		int res2=stuSer.deleteStudent(new Student (111,"vaishali",4000.0f));
		System.out.println(" Deleted  "+res2);
		}
		catch(Exception de)
		{
			System.out.println("duplicate roll no.");
		}
		
	}*/
	System.out.println("******* Get All Student*****************");
		Student ss=stuSer.getStudentByRollNo(111);
		System.out.println(ss);
		
		System.out.println("******* Get All Student List*****************");
		List<Student> stuList=stuSer.getAllStudent();
		System.out.println(stuList);
	
	

}
}
