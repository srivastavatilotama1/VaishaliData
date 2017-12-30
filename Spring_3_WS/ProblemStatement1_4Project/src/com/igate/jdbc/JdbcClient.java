package com.igate.jdbc;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JdbcClient {


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		ApplicationContext bf=new ClassPathXmlApplicationContext("jdbc.xml");
		Employee emp=(Employee)bf.getBean("e1");
		
			System.out.println(emp);
			
			Student stu=(Student)bf.getBean("s1");
			
			System.out.println(stu);
		
		
		
		

	}

}
