package com.cg.eis.dao;
import java.util.ArrayList;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
public interface IEmpDao 
{
	public int addEmployee(Employee emp)throws EmployeeException;	
	public ArrayList<Employee> getAllEmp();
}
