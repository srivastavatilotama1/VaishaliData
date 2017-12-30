package com.igate.service;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.igate.bean.Emp;
import com.igate.dao.EmpDaoImpl;
import com.igate.exception.EmpException;
public class EmpServiceImpl  implements IEmpService
{
	EmpDaoImpl empDao=new EmpDaoImpl();
	@Override
	public void addAllEmp(Emp emp) throws EmpException
	{
		
		empDao.insertEmp(emp);
		System.out.println("Emp Service has invoked insert method properly");
	}
	@Override
	public ArrayList getAllEmp() throws EmpException
	{			
		return empDao.getAllEmp();
	}
	
	public boolean validateEmpId(String id)
	{
		String empIdPattern="[0-9]*";
		if(Pattern.matches(empIdPattern,id))
		{
			return true;			
		}
		else
		{
			System.out.println(" Emp Id should be only digits ");
			return false;
		}
	}

}
