package com.igate.bean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class EmployeeMain 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
	
		SBU sbu = (SBU) ctx.getBean("businessUnit");
		System.out.println(sbu.toString());
	//	System.out.println(sbu.);
	}

}
