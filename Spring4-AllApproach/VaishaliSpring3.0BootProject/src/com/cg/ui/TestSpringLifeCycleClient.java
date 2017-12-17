package com.cg.ui;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cg.bean.ICurrencyConvertor;
import com.cg.bean.IGreet;
import com.cg.bean.NewYearWishGreetImpl;
@ComponentScan("com.cg")
public class TestSpringLifeCycleClient 
{
	public static void main(String[] args)
	{
		ApplicationContext ctx=SpringApplication.
				run(TestSpringLifeCycleClient.class, args);		
		
		IGreet greet1=(IGreet)ctx.getBean("obj1");
		 System.out.println(greet1.greetMe());
		 		 
		 IGreet greet2=(IGreet)ctx.getBean("obj1");
		 System.out.println(greet2.greetMe());
		 
		 
		
	}

}
