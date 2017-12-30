package com.igate.jaxb.unmarshal;

import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;

public class TestDeptUnMarshaller 
{
	public static void main(String[] args) throws Exception 
	{	
		//List<Department> deptList=EmployeeRepository.getDepartments();		
	   // Creating an Unmarshaller
		JAXBContext jaxbCtxt = JAXBContext.newInstance(Depts.class);
		Unmarshaller jaxbUnmarshaller = jaxbCtxt.createUnmarshaller();
  
		File ff=new File("depts.xml")   ;
		//Converting XML to java object using JAXB unmarshal API.
		Depts depts = (Depts)jaxbUnmarshaller.unmarshal(ff)  ;

		System.out.println(depts.getDeptList());
    
    }
}  
 
 