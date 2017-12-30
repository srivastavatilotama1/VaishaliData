package com.igatepatni.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class OxmJaxbTest1 {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		Jaxb2Marshaller jaxbMarshaller = (Jaxb2Marshaller)context.getBean("jaxbMarshaller");
		
		Map<String, Boolean> marshallerProperties = new HashMap<String, Boolean>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setMarshallerProperties(marshallerProperties);
		
		//marshalObject(jaxbMarshaller);
		unmarshallXML(jaxbMarshaller);
		
	}
	
	private static void marshalObject(Jaxb2Marshaller jaxbMarshaller) throws Exception{
				
		Department department = new Department();
		department.setId("IT");
		department.setName("IT Department");
		
		Employee employee = new Employee("12345", "Test Employee");
		//employee.setDepartment(department);
		
		FileOutputStream outputStream = new FileOutputStream(new 
				File("employee.xml"));
		StreamResult result = new StreamResult(outputStream);
		
		jaxbMarshaller.marshal(employee, result);		
	}

	private static void unmarshallXML(Jaxb2Marshaller jaxbMarshaller) throws Exception{
						
		FileInputStream inputStream = new FileInputStream(new File("employee.xml"));
		StreamSource source = new StreamSource(inputStream);
		
		//Employees emps = (Employees)jaxbMarshaller.unmarshal(source);
		Employees emps = (Employees)jaxbMarshaller.unmarshal(source);
		System.out.println(emps.getEmployees().get(0).getName());
		/*List l = emps.getEmployees();
		System.out.println(l);
		Iterator it = l.iterator();
		while(it.hasNext()){
			Employee employee = (Employee)it.next();
		System.out.println("Emp Id is " + employee.getId());
		System.out.println("Emp Name is " + employee.getName());
		}*/
		//Department department = employee.getDepartment();
		//System.out.println("Dept Id is " + department.getId());
		//System.out.println("Dept Name is " + department.getName());
	}
}