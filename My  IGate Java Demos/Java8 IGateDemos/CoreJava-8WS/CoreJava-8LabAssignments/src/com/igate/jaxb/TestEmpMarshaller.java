package com.igate.jaxb;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class TestEmpMarshaller 
{
	private static final String EMP_XML = "IGateEmp.xml";
	private static final String DEPT_XML = "IGateDept.xml";
	public static void main(String[] args) throws Exception 
	{			
		Employees emps=new Employees();				
		List<Employee> empList=EmployeeRepository.getEmployees();		
		emps.setEmpList(empList);
		
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		//m.setProperty(Marshaller.JAXB_ENCODING,Boolean.TRUE);
		//	m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,Boolean.FALSE);


		// Write to System.out
		m.marshal(emps, System.out);

		// Write to File
		m.marshal(emps, new File(EMP_XML));

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");

	}

}
