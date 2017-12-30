package com.igate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.igate.bean.Student;
@Repository("studentDao")
public class StudentDAO 
{
	@Autowired
	//	@Qualifier("simpleJdbcTem")
	private JdbcTemplate jdbcTemplate;

	public int addStudent(Student student)
	{
		String insertQry="insert into  stu values(?,?,?)";

		Object[] param=new 
		Object[]{student.getRoll(),student.getName(),student.getFees()};
		int result=jdbcTemplate.update(insertQry,param);
		return result;

	}

	public int deleteStudent(Student stu)
	{
		String delQry="DELETE FROM stu WHERE roll=?";
		Object param[]=new Object[]{stu.getRoll()};
		int res=jdbcTemplate.update(delQry,param);
		return res;

	}

	public int updateFees(Student stu)
	{

		String updateQry="update stu set fees=? where roll=?";

		Object []updateparam=new Object[]{stu.getFees(),stu.getRoll()};
		int res3=jdbcTemplate.update(updateQry,updateparam);
		return res3;	
	}

	public Student getStudentByRollNo(int rollno)
	{
		String selQry="select * from stu where roll=?";

		Object []updateparam=new Object[]{rollno};
		Student  stu=jdbcTemplate.queryForObject(selQry,updateparam, new StudentMapper());
		return stu;	
	}
	
	public List<Student> getAllStudent()
	{
		String selQry="select * from stu";
		
		return jdbcTemplate.query(selQry, new StudentMapper());
		
	}

}
