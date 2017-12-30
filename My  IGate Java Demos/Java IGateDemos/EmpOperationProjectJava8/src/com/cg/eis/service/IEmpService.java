package com.cg.eis.service;
import java.sql.Date;
import java.time.LocalDate;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
public interface IEmpService 
{
	public int addEmployee(Employee emp)
			throws EmployeeException;	
	public Employee fetchEmployeeDetailsById(int empId);
	public Employee updateEmpSal(int empId,float newSalary);
	public Date getDOJ(int empId);
	public   boolean validateEmpName(String empName);
	public Date convertToSQLDate(LocalDate empLocalDate);
	public LocalDate convertStrToLocalDate(String empDOJ);
	


}
