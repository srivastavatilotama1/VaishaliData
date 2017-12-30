package com.igate.msg;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorldClient
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanConfig.xml");
		
		System.out.println("**********First Bean Using Bean Factory *************");
		HelloWorld myBean1 = (HelloWorld) ctx
		.getBean("HelloWorldBean");		
		myBean1.sayHelloInAllLanguage();
		
			}

}
