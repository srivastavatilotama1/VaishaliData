package com.igate.jdbc.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.exception.ApplicationException;
import com.igate.jdbc.service.IApplicationService;

@ComponentScan("com.igate")
@EnableAutoConfiguration

public class JdbcClient { 
	public static void main(String[] args) 
	{ 
		/*System.out.println(" In Main*********************************");
		System.setProperty("spring.profiles.active", "dev");

		System.out.println(" After System.setProperty********************");

		//Instantiate spring container using spring boot
		ApplicationContext context = SpringApplication.run(JdbcClient.class, args);
		System.out.println(" SpringApplication.run********************");
		IApplicationService service = (IApplicationService) context.getBean("service");    	
		//execute queryForInt 
		List<Application> applicationList;
		Scanner sc=new Scanner (System.in);
		System.out.print("Enter Application Id :");
		int appId=sc.nextInt();

		System.out.print("Enter User  Name :");
		String un=sc.next();

		System.out.print("Enter Email Id  :");
		String email=sc.next();

		System.out.print("Enter Mobile No  :");
		String mobileNo=sc.next();

		System.out.print("Enter City   :");
		String city=sc.next();

		System.out.print("Enter Day   :");
		int dd=sc.nextInt();		
		System.out.print("Enter Month   :");
		int mm=sc.nextInt();
		System.out.print("Enter Year   :");
		int yy=sc.nextInt();
		
		
	//	System.out.println(" Enter Date in dd-mm-yyyy format ");
	//	String strDate=sc.next();
	

		System.out.print("Does Account Exist ?   Y/N :");
		String accountExist=sc.next();

		Application application=new Application(appId,un,
				email,mobileNo,city,
				LocalDate.of(yy, mm, dd),accountExist);

		System.out.println(" Data Inserted in table"+
				service.insertApplication(application));
		
		System.out.println("***************** Get  All Data***************************");
		applicationList = service.getAllApplicationDetails();
		System.out.println("applications in the table :"+applicationList);
	

		*/



	} 
} 
