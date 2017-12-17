package com.cg.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Employee;
import com.cg.bean.Person;
import com.cg.bean.User;

public class TestSpelClientDemo {

	public static void main(String[] args) 
	{
		ApplicationContext ctx=
				new  ClassPathXmlApplicationContext("cg.xml");
		Employee tempEmp=(Employee)ctx.getBean("e1");
		System.out.println("\n************Employee*****************");
		System.out.println(tempEmp);
		System.out.println("\n************Person*****************");
		Person tempPer=(Person)ctx.getBean("per");
		System.out.println(tempPer);
		
	System.out.println("\n************User*****************");
		User tempUser=(User)ctx.getBean("ur");
		System.out.println(tempUser);

	}

}
