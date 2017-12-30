package com.igate.intro;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorldClient
{
	public static void main(String[] args) 
	{
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
		"beanConfig.xml"));

		System.out.println("**********First Bean Using Bean Factory *************");
		HelloWorld myBean1 = (HelloWorld) beanFactory
		.getBean("HelloWorldBean");		
		myBean1.sayHello();		
		System.out.println("HashCode Of myBean2  Is : "+myBean1.hashCode());
	
		System.out.println("*********Second  Bean Using Bean Factory *************");
		HelloWorld myBean2 = (HelloWorld) beanFactory.getBean("HelloWorldBean");		
		myBean2.sayHello();		
		System.out.println("HashCode Of myBean2  Is : "+myBean2.hashCode());


		System.out.println("*********Third  Bean Using Application Context*********");
		ApplicationContext ctx3 = new ClassPathXmlApplicationContext("beanConfig.xml");
		HelloWorld myBean3 = (HelloWorld) ctx3.getBean("HelloWorldBean");		
		myBean3.sayHello();		
		System.out.println("HashCode Of myBean3  Using ContextIs : "+myBean3.hashCode());


		System.out.println("*********Forth Bean Using Application Context*********");
		ApplicationContext ctx4 = new ClassPathXmlApplicationContext("beanConfig.xml");
		HelloWorld myBean4 = (HelloWorld) ctx4.getBean("HelloWorldBean");		
		myBean4.sayHello();		
		System.out.println("HashCode Of myBean4  Is : "+myBean4.hashCode());


		/****************OutPut************************
		 * **********First Bean Using Bean Factory *************
 HelloWorldBean is going through init.
Hello Spring 3.0
HashCode Of myBean2  Is : 8345058
		 *********Second  Bean Using Bean Factory *************
Hello Spring 3.0
HashCode Of myBean2  Is : 8345058
		 *********Third  Bean Using Application Context*********
 In InitHelloWorld  BeforeInitialization : HelloWorldBean
 HelloWorldBean is going through init.
 In InitHelloWorld  AfterInitialization : HelloWorldBean
Hello Spring 3.0
HashCode Of myBean3  Using ContextIs : 13772896
		 *********Forth Bean Using Application Context*********
 In InitHelloWorld  BeforeInitialization : HelloWorldBean
 HelloWorldBean is going through init.
 In InitHelloWorld  AfterInitialization : HelloWorldBean
Hello Spring 3.0
HashCode Of myBean4  Is : 23649229

		 * 
		 * 
		 */




	}

}
