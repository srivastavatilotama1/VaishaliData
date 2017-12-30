package com.igate.jaxb;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class TestEmpDeptMarshaller 
{
	private static final String EMP_XML = "IGateEmp.xml";
	private static final String DEPT_XML = "IGateDept.xml";
	public static void main(String[] args) throws Exception 
	{			
		Employees emps=new Employees();		
		
		List<Employee> empList=EmployeeRepository.getEmployees();	
		List<Department> deptList=EmployeeRepository.getDepartments();
		
		
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		
		Marshaller m = context.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		List<Employee> eList=null;
		String deptName=null;
		for(Department deptTemp:deptList)
		{
			 deptName=deptTemp.getDepartmentName();
			 int deptId=deptTemp.getDepartmentId();
			
			
			System.out.println(deptId+ ": "+deptName);
			eList=
					empList.stream().
					filter((employee)->(employee.getDepartment()!=null)
							&&employee.getDepartment().getDepartmentId()==deptId).
					collect(Collectors.toList());	
			System.out.println(eList);
			emps.setEmpList(eList);
			m.marshal(emps, new File(deptName+".xml"));
		}	

	}

}
