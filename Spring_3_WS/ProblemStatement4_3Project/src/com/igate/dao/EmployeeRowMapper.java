package com.igate.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Employee;


public class EmployeeRowMapper implements RowMapper
{

	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp= new Employee(
				rs.getInt("eid"),rs.getString("enm"),
				rs.getInt("esal"));
		
		return emp;
	}

}
