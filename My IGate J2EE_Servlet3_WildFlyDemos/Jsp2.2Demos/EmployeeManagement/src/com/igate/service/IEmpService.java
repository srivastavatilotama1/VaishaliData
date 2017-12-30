package com.igate.service;

import java.util.ArrayList;

import com.igate.dto.Employee;
import com.igate.exception.EmployeeException;

public interface IEmpService {

	public int generateEmpId()throws EmployeeException;
	public int  inserEmp(Employee employeeDto)throws
	EmployeeException;
	public ArrayList<Employee> getAllEmp()throws 
	EmployeeException;
}
