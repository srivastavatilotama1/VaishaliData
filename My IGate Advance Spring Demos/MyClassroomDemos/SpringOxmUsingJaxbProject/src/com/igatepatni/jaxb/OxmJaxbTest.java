package com.igatepatni.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class OxmJaxbTest {

	public static void main(String[] args) throws Exception {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		Jaxb2Marshaller jaxbMarshaller = (Jaxb2Marshaller)context.getBean("jaxbMarshaller");
		
		Map<String, Boolean> marshallerProperties = new HashMap<String, Boolean>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setMarshallerProperties(marshallerProperties);
		
		marshalObject(jaxbMarshaller);
		unmarshallXML(jaxbMarshaller);
		
	}
	
	private static void marshalObject(Jaxb2Marshaller jaxbMarshaller) throws Exception{
				
		Department department = new Department();
		department.setId("IT");
		department.setName("IT Department");
		
		Employee employee = new Employee("12345", "Vaishali");
		employee.setDepartment(department);
		
		
		Department department2 = new Department();
		department2.setId("Act");
		department2.setName("Acout Department");
		
		Employee employee2 = new Employee("1111", "Priti");
		employee2.setDepartment(department2);
		
		
		
		
		Employees emps=new Employees();
		ArrayList empList=new ArrayList();
		empList.add(employee);
		empList.add(employee2);
		emps.setEmployees(empList);
		
		
		FileOutputStream outputStream = new FileOutputStream(new File("employee.xml"));
		StreamResult result = new StreamResult(outputStream);
		
		
		jaxbMarshaller.marshal(emps, result);	
	}

	private static void unmarshallXML(Jaxb2Marshaller jaxbMarshaller) throws Exception{
						
		FileInputStream inputStream = new FileInputStream(new File("employee.xml"));
		StreamSource source = new StreamSource(inputStream);
		
		Employees employees = (Employees)jaxbMarshaller.unmarshal(source);
		List<Employee> employeeList=employees.getEmployees();
		
		
		System.out.println("Emp Id is " + employeeList.get(0).getId());
		System.out.println("Emp Name is " + employeeList.get(0).getName());
		
		//Department department = employee.getDepartment();
		//System.out.println("Dept Id is " + department.getId());
		//System.out.println("Dept Name is " + department.getName());
	}
}