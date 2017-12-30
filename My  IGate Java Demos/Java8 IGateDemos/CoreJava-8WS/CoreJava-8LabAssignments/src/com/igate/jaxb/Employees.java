package com.igate.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="emps",namespace="com.emp.igate")
@XmlType(name="empsType",propOrder={"empList"})
public class Employees
{
	@Override
	public String toString()
	{
		return "Employess [empList=" + empList + "]";
	}

	@XmlElement( name="emp",required=true)
	private List<Employee> empList;

	public List<Employee> getEmpList() 
	{
		return empList;
	}

	public void setEmpList(List<Employee> empList)
	{
		this.empList = empList;
	}

	

}
