package com.igate.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.jdbc.bean.Employee;

@Repository("dao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired
	private DataSource myDataSource;
	@PostConstruct
	private void initialize() 
	{
		setDataSource(myDataSource);
	}		
	public List<Employee> getAllEmp()
	{
		String sql="SELECT * FROM employees";
		List<Employee> empList =getJdbcTemplate().
				query(sql, (rs,rowNum) ->{
							Employee emp = new Employee();
								emp.setEid(rs.getInt(1));
									emp.setEnm(rs.getString(2));
										emp.setEsl(rs.getDouble(3));
										return emp;
				});
		return empList;
    }
}
