package com.igatepatni.castor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.castor.CastorMarshaller;

public class OxmCastorTest 
{

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("castor-context.xml");
		CastorMarshaller marshaller = (CastorMarshaller)context.getBean("castorMarshaller");

		testObjectToXml(marshaller);
	//	testXmlToObject(marshaller);
	}

	private static void testObjectToXml(CastorMarshaller marshaller) throws Exception{
			
		Employees emps=new Employees();
		Employee empObject = new Employee("12345", "Shrjjilata", 2000.00);
		Employee empObject2 = new Employee("222","Vaishali", 1000.00);
		Employee empObject3 = new Employee("444", "Anju", 2000.00);
		
		ArrayList empList=new ArrayList();
		empList.add(empObject);
		empList.add(empObject2);
		empList.add(empObject3);
		
		emps.setEmployees(empList);
		FileOutputStream outputStream = new FileOutputStream(new File("castor-employee.xml"));
		StreamResult xmlFileResult = new StreamResult(outputStream);
		
		marshaller.marshal(emps, xmlFileResult);		
	}
	
	/*private static void testXmlToObject(CastorMarshaller marshaller) throws Exception{
		
		
		FileInputStream inputStream = new FileInputStream(new File("mobile.xml"));
		StreamSource xmlFileSource = new StreamSource(inputStream);
				
		marshaller.setTargetClass(Mobile.class);
		Mobile mobileObject = (Mobile)marshaller.unmarshal(xmlFileSource);
		
		System.out.println("Name is " + mobileObject.getName());
		System.out.println("Model is " + mobileObject.getModel());
		System.out.println("Price is " + mobileObject.getPrice());
	}*/
}