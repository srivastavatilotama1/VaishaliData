package com.cg.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cg.bean.ICurrencyConvertor;
import com.cg.bean.IGreet;
import com.cg.bean.NewYearWishGreetImpl;

public class TestSpringCurrClient 
{
	public static void main(String[] args)
	{
		Resource res=new ClassPathResource("cg.xml");
		BeanFactory factory=new XmlBeanFactory
				(res);			
		 
		ICurrencyConvertor currC1= (ICurrencyConvertor)factory.
				getBean("currencyConObj1");
		System.out.println(" 50 Doller Is ? "+
				currC1.dollerToRupees(50) + "   RS. ");
		
		ICurrencyConvertor currC2= (ICurrencyConvertor)factory.
				getBean("currencyConObj2");
		System.out.println(" 30 Yen Is ? "+
				currC2.yenToRupees(30) + "   RS. ");
		
		

	}

}
