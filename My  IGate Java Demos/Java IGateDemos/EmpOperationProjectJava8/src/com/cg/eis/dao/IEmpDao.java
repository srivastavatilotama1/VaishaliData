package com.cg.eis.dao;
import java.sql.Date;
import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
public interface IEmpDao 
{
	public int addEmployee(Employee emp)
			throws EmployeeException;	
	public Employee fetchEmployeeDetailsById(int empId);
	public Employee updateEmpSal(int empId,float newSalary);
	public Date getDOJ(int empId);

}
