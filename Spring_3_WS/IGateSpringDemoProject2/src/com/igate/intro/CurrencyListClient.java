package com.igate.intro;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class CurrencyListClient {


	public static void main(String[] args) 
	{		
		Resource res = new ClassPathResource("currencyconverter.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		CurrencyList curr = (CurrencyList)factory.getBean("currencyList");
		List curs = curr.getCurrList();
		System.out.println(curs);
	
	}

}
