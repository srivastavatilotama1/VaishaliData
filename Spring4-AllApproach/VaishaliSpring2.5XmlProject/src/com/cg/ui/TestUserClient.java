package com.cg.ui;

//import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.User;
//@Configuration
//@ComponentScan("com.cg")
public class TestUserClient {

	public static void main(String[] args)
	{
		ApplicationContext ctx=new 
				ClassPathXmlApplicationContext("cg.xml");
		
		
		User u=(User)ctx.getBean("ur");
		System.out.println(" My User Id Id : "+
		u.getUserName());
		System.out.println(" My User Password Is  : "+
				u.getPassword());

	}

}
