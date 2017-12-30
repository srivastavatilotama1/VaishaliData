package com.igate.service;

import java.util.List;

import com.igate.bean.Employee;

public interface IEmpService 
{
	public boolean insertEmployee(Employee customer);
	public int getEmpCount();	
	public String getEmployeeName(int eid);	
	public int updateEmp(Employee emp);
	public Employee getEmpByEid(int eid) ;	
    public List<Employee> getEmployeeListBySal();
    public List<Employee> getEmployeeList() ;
}
