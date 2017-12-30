package com.igate.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class EmployeeMain 
{

	public static void main(String[] args) 
	{

		Resource res = new ClassPathResource("employee.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Employee emp1 = (Employee) factory.getBean("empBean1");
		emp1.dispEmp();
		
		System.out.println("*********Using Constructor********************");
		Employee emp2 = (Employee) factory.getBean("empBean2");
		emp2.dispEmp();
	}

}
