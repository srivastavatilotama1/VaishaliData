package com.igate.eis.service;

import java.util.List;

import com.igate.eis.bean.Employee;

public interface EmployeeService 
{
	public void addEmployee(Employee ee);
	public void getEmploeesByScheme(String  insuranceScheme);
	public void deleteEmployees(int empId);
	public void sortEmp();
	public void dispEmps();
	public void sortEmpBySal();
	public void searchEmpByScheme( String scheme);
	

}
