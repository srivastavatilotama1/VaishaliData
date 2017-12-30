package com.igate.service;

import java.util.ArrayList;

import com.igate.dao.EmpDaoImpl;
import com.igate.dao.IEmpDao;
import com.igate.dto.Employee;
import com.igate.exception.EmployeeException;
public class EmpServiceImpl implements IEmpService 
{
	IEmpDao empDao=new EmpDaoImpl();
	@Override
	public int generateEmpId() throws EmployeeException {		
		return empDao.generateEmpId();
	}
	@Override
	public int inserEmp(Employee employeeDto) 
			throws EmployeeException {
				return empDao.inserEmp(employeeDto);
	}
	@Override
	public ArrayList<Employee> getAllEmp() throws
	EmployeeException {		
		return empDao.getAllEmp();
	}

}
