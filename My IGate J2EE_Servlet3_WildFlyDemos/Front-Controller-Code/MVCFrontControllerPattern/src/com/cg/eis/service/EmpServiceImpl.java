package com.cg.eis.service;

import java.util.ArrayList;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmpDaoImpl;
import com.cg.eis.dao.IEmpDao;
import com.cg.eis.exception.EmployeeException;
public class EmpServiceImpl  implements IEmpService
{
	IEmpDao empDao=new EmpDaoImpl();
	@Override
	public int addEmployee(Employee emp) throws EmployeeException
	{
			return empDao.addEmployee(emp);
	}
	@Override
	public ArrayList<Employee> getAllEmp() {
		
		return empDao.getAllEmp();
	}	
}
