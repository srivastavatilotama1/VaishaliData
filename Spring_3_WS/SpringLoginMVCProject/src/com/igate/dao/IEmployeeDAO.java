package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Employee;


public interface IEmployeeDAO 
{
	public boolean insertEmployee(Employee customer);
	public int getEmpCount();	
	public String getEmployeeName(int eid);	
	public int updateEmp(Employee emp);
	public Employee getEmpByEid(int eid) ;	
    public List<Employee> getEmployeeListBySal();
    public List<Employee> getEmployeeList() ;
    }
