package com.igate.intro;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class CurrencyConverterClient {

	public static void main(String args[]) throws Exception
	{
		Resource res = new ClassPathResource("currencyconverter1.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		CurrencyConverter curr = (CurrencyConverter) factory.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(3.0);
		System.out.println("3 $ is "+rupees+" Rs.");
		System.out.println("******************Constructor Injection******");
		
		Resource res2 = new ClassPathResource("currencyconverter2.xml");
		BeanFactory factory2 = new XmlBeanFactory(res2);
		CurrencyConverter curr2 = (CurrencyConverter) factory2.getBean("currencyConverter");
		double rupees2 = curr2.dollarsToRupees(34.0);
		System.out.println("34$ is "+rupees2+" Rs.");

	}
}
