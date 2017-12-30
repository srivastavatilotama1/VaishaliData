package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.igate.bean.Employee;
import com.igate.dao.IEmployeeDAO;

@Repository("empSer")
public class EmployeeServiceImpl implements IEmpService
{
	@Autowired
	@Qualifier("empDAO")
	IEmployeeDAO empDAO;
	@Override
	public boolean insertEmployee(Employee emp) 
	{		
		return empDAO.insertEmployee(emp);		
	}
	@Override
	public int getEmpCount() 
	{		
		return 0;
	}
	@Override
	public String getEmployeeName(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmp(Employee emp) {
		
		return empDAO.updateEmp(emp);
	}

	@Override
	public Employee getEmpByEid(int eid) {
		// TODO Auto-generated method stub
		return empDAO.getEmpByEid(eid);
	}

	@Override
	public List<Employee> getEmployeeListBySal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeList() 
	{
		return empDAO.getEmployeeList();	
		
	}

}
