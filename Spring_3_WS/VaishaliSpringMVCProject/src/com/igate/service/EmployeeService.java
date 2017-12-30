package com.igate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.igate.dao.EmployeeDAO;
import com.igate.dto.Employee;

@Service("empService")
public class EmployeeService
{	@Autowired
	@Qualifier("empDao")
	EmployeeDAO employeeDao;
	public boolean addEmployee(Employee employee)
	{
		return employeeDao.addEmployee(employee);		
	}

}
