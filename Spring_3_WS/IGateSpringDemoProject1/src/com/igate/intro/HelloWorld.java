package com.igate.intro;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

public class HelloWorld 
{
	
	public void sayHello()
	{
		System.out.println("Hello Spring 3.0");
	}
	public void init()
	{
		System.out.println(" HelloWorldBean is going through init.");
	}

	
	public void destroy()
	{
		System.out.println(" HelloWorld Bean will destroy now.");
	}

	

}
