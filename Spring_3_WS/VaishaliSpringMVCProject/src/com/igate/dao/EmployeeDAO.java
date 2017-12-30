package com.igate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.igate.dto.Employee;
@Repository("empDao")
public class EmployeeDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addEmployee(Employee employee)
	{
		String insertEmp ="select into IEmp VALUES(?,?,?,?,?,?,?,?,?)";
		
		Object [] objParam=new Object[]{employee.getEmployeeId(),
		employee.getFirstName(),employee.getLastName(),
		employee.getCity(),employee.getPrefLanguages(),
		employee.getMaritalStaus(),employee.getSalary(),
		employee.getJoinedDate(),employee.getAnnualPackage()		
		};
		
		int result=jdbcTemplate.update(insertEmp,objParam);
		if(result==1)
		{
			return true;
		}
		else
		{
			return false;
		}

		
	}

}
