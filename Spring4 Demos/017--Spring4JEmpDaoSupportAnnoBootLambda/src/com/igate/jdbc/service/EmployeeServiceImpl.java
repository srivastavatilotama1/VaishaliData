package com.igate.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.jdbc.bean.Employee;
import com.igate.jdbc.dao.EmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;
		
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	public List<Employee> getAllEmp()
	{
		return dao.getAllEmp();
	}

	
}
