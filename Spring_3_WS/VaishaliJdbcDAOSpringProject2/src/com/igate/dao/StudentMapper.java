package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Student;

public class StudentMapper implements RowMapper<Student>
{
//args1 is row number //maprow is executed for every row of resultset.
	@Override
	public Student mapRow(ResultSet resultset, int rownum) throws SQLException 
	{
		Student stu=new Student();
		stu.setRoll(resultset.getInt("roll"));
		stu.setName(resultset.getString("name"));
		stu.setFees(resultset.getDouble("fees"));
		return stu;
	}

}
