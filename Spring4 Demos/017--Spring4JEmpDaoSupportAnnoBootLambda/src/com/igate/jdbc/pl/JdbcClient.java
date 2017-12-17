package com.igate.jdbc.pl;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;

import com.igate.jdbc.bean.Employee;
import com.igate.jdbc.service.EmployeeService;

@ComponentScan("com.igate")
 @EnableAutoConfiguration
public class JdbcClient { 
 

    public static void main(String[] args) { 
    	System.setProperty("spring.profiles.active", "dev");
    	ApplicationContext context = SpringApplication.run(JdbcClient.class, args);
    	EmployeeService service = (EmployeeService) context.getBean("service");
    	
		//execute queryForInt 
		List<Employee> eList=service.getAllEmp();
		  System.out.println("Employees in the table :"+eList);
		  
    } 
} 
