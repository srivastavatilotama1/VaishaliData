package com.igate.unmarshal;

import java.io.File;
import java.io.StringReader;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.igate.jaxb.EmpNameType;
import com.igate.jaxb.Employee;
import com.igate.jaxb.Employees;


public class TestEmpUnMarshaller 
{
	private static final String EMP_XML = "emp.xml";
	public static void main(String[] args) throws Exception 
	{	
				
	   // Creating an Unmarshaller
		JAXBContext jaxbCtxt = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbCtxt.createUnmarshaller();
  
		File ff=new File("emp.xml")   ;
		//Converting XML to java object using JAXB unmarshal API.
		Employees emps = (Employees)jaxbUnmarshaller.unmarshal(ff)  ;
		System.out.println(emps.getEmpList());
   
    
    }
}  
 
 