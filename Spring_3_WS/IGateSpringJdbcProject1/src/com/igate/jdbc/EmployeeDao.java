package com.igate.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao 
{
	@PostConstruct
	void init(){
		System.out.println("in init() - called thru @PostConstruct");
	}

	@PreDestroy
	void destroy(){
		System.out.println("in destroy() - called thru @PreDestroy");
	}
	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;


	public SimpleJdbcTemplate getSimpleJdbcTemplate() 
	{
		return simpleJdbcTemplate;
	}
	@Autowired
	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate)
	{
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}

	public int getCount()
	{
		int count=0;
		count=simpleJdbcTemplate.queryForInt("select count(*) from employee414");
		return count;
	}

	public String getEmployeeName(int eid)
	{
		String sql = "SELECT enm from employee414 where eid=?";
		String name=getSimpleJdbcTemplate().queryForObject(sql,String.class,eid);
		return name;
	}

	public int insertRec(int eid,String enm,double esl)
	{
		String sql="insert into employee414 values(?,?,?)";   
		Object[] params=new Object[]{eid,enm,esl};
		return simpleJdbcTemplate.update(sql, params);
	}

	public int updateRec(int eid,String enm,double esl)
	{
		String sql="update employee414 set enm=?,esl=? where eid=?";
		Object[] params = new Object[]{enm,esl,eid};
		int update=simpleJdbcTemplate.update(sql, params);
		return update;
	}

	public List getAll()
	{
		Object[] params=new Object[]{new Double(40000.00)};
		List list=simpleJdbcTemplate.queryForList("SELECT * from employee414 where esl > ?",params);
		return list;
	}

	// to retrieve the an employee given eid
	public Employee getEmpByEid(int eid) 
	{

		String sql = "SELECT eid,enm,esl from employee414 where eid=?";

		RowMapper mapper = new RowMapper() 
		{
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setEnm(rs.getString(2));
				e.setEsl(rs.getDouble(3));
				System.out.println(rowNum);
				return e;
			}

		};

		Employee employee= (Employee) simpleJdbcTemplate.queryForObject(sql,mapper,eid);
		return employee;

	}

	public List<Employee> getEmployeeList() 
	{
		String sql = "SELECT * FROM employee414";
		List<Employee> eList =simpleJdbcTemplate.query(sql,new EmployeeRowMapper());
		return eList;
	}



}
