package com.cg.ui;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cg.bean.ICurrencyConvertor;
import com.cg.bean.IGreet;
import com.cg.bean.NewYearWishGreetImpl;
public class TestSpringLifeCycleClient 
{
	public static void main(String[] args)
	{
		//Resource res=new ClassPathResource("basic.xml");
		//BeanFactory factory=new XmlBeanFactory
		//		(res);		
		ApplicationContext ctx=
				new  ClassPathXmlApplicationContext("basic.xml");
		 IGreet greet1=(IGreet)ctx.getBean("obj1");
		 System.out.println(greet1.greetMe());
		 		 
		/* IGreet greet2=(IGreet)ctx.getBean("obj1");
		 System.out.println(greet2.greetMe());
		 
		 System.out.println(greet1.hashCode());
		 System.out.println(greet2.hashCode());
		 try {
			((NewYearWishGreetImpl)greet1).destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
