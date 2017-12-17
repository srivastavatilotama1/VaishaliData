package com.cg.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Address;
import com.cg.bean.Employee;
import com.cg.bean.Person;
import com.cg.bean.User;

public class TestSpelClientDemo {

	public static void main(String[] args) 
	{
		ApplicationContext ctx=
				new  ClassPathXmlApplicationContext("cg.xml");

		Address a1=(Address)ctx.getBean("offAdd");
		System.out.println(a1);
		System.out.println("************ Person Info************");

		Person tempPer=(Person)ctx.getBean("per");
		System.out.println(tempPer);

		System.out.println("************ Emp Info************");

		Employee tempEmp=(Employee)ctx.getBean("empObj");
		System.out.println(tempEmp);

	}

}
