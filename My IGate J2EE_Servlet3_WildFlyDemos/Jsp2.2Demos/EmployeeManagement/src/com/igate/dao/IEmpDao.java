package com.igate.dao;
import java.util.ArrayList;

import com.igate.dto.Employee;
import com.igate.exception.EmployeeException;


public interface IEmpDao 
{
	public int generateEmpId()throws EmployeeException;
	public int  inserEmp(Employee employeeDto)throws
	EmployeeException;
	public ArrayList<Employee> getAllEmp()throws 
	EmployeeException;

}
