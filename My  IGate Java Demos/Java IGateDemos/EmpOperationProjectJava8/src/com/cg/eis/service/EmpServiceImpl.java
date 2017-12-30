package com.cg.eis.service;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmpDaoImpl;
import com.cg.eis.dao.IEmpDao;
import com.cg.eis.exception.EmployeeException;
public class EmpServiceImpl  implements IEmpService
{
	IEmpDao empDao=new EmpDaoImpl();
	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
			return empDao.addEmployee(emp);
	}
	@Override
	public Employee fetchEmployeeDetailsById(int empId) {		
		return empDao.fetchEmployeeDetailsById(empId);
	}
	@Override
	public Employee updateEmpSal(int empId, float newSalary) {	
		return null;
	}
	@Override
	public Date getDOJ(int empId) {	
		return null;
	}
	@Override
	public boolean validateEmpName(String empName)
	{		
		String namePattern="[A-Z][a-z]{0,19}";
		if(Pattern.matches(namePattern, empName))
		{
			return true;
		}
		else
		{
			System.out.println(" Emp  Name Should Start With "+
					" Capital and  max 20 char is allowed");
			return false;			
		}		
	}
	
	@Override
	public LocalDate convertStrToLocalDate(String empDOJ) 
	{
		DateTimeFormatter dateTimeFormat=DateTimeFormatter.
				ofPattern("dd-MMM-yyyy");
		LocalDate localDoj=LocalDate.
				parse(empDOJ, dateTimeFormat);
		return localDoj;
	}
	public  Date convertToSQLDate(LocalDate empLocalDate)
	{
		Date sqlDate=Date.valueOf(empLocalDate);
		
		return sqlDate;
	}
	public LocalDate convertToLocalDate(Date sqlDOJ)
	{
		LocalDate localDateDOJ=sqlDOJ.toLocalDate();
			return localDateDOJ;
	}
}
