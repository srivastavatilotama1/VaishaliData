package com.cg.eis.service;
import java.util.ArrayList;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
public interface IEmpService 
{
	public int addEmployee(Employee emp)throws EmployeeException;	
	public ArrayList<Employee> getAllEmp();
	
}
