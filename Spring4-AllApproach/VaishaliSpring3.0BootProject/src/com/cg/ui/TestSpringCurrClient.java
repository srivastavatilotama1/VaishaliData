package com.cg.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.ICurrencyConvertor;
import com.cg.bean.IGreet;
import com.cg.bean.NewYearWishGreetImpl;
@ComponentScan("com.cg")
public class TestSpringCurrClient 
{
	public static void main(String[] args)
	{
		ApplicationContext ctx=SpringApplication.run(TestSpringCurrClient.class, args);		
		 
		System.out.println("******************");
		 IGreet greet1=(IGreet)ctx.getBean("obj1");
		 System.out.println(greet1.greetMe());
		
		 System.out.println("******************");
		
		ICurrencyConvertor currC1= (ICurrencyConvertor)ctx.
				getBean("currencyConObj1");
		System.out.println(" 50 Doller Is ? "+
				currC1.dollerToRupees(50) + "   RS. ");
		
		/*ICurrencyConvertor currC2= (ICurrencyConvertor)ctx.
				getBean("currencyConObj2");
		System.out.println(" 30 Yen Is ? "+
				currC2.yenToRupees(30) + "   RS. ");*/
		
		

	}

}
