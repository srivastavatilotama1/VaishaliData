package com.igate.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

		 public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
         EmployeeIntfc eDao = (EmployeeIntfc) context.getBean("employeeDao");
         Employee emp=eDao.getEmployee(101);
         
         if(emp!=null)
         {
          System.out.println("Employee Info");
          System.out.println(emp.getEid());
          System.out.println(emp.getEnm());
          System.out.println(emp.getEsl());
         }
         else
         {
        	 System.out.println("Employee not present"); 
         }

	}

}
