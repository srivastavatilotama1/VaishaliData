package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Employee;


public class EmployeeDAO implements IEmployeeDAO
{

	 private JdbcTemplate jdbcTemplate;
		    
	   public JdbcTemplate getJdbcTemplate() 
	   {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

		@Override
		public void insertEmployee(Employee employee)
	    {
	        String query = "INSERT INTO EMPLOYEE414 (EID, ENM, ESAL) VALUES (?,?,?)";
	        jdbcTemplate.update(query, new Object[] { Integer.valueOf(employee.getEid()), 
	        		employee.getEnm(), employee.getEsl() });
	    }

		@Override
		public int getEmpCount() {
			int count=0;
			count=jdbcTemplate.queryForInt("select count(*) from employee414");
			return count;
		}

		@Override
		public String getEmployeeName(int eid) {
			String sql = "SELECT enm from employee414 where eid=?";
			String name=jdbcTemplate.queryForObject(sql,String.class,eid);
			return name;
		}

		@Override
		public int updateEmp(int eid, String enm, double esl) 
		{
			 String sql="update employee414 set enm=?,esal=? where eid=?";
			    Object[] params = new Object[]{enm,esl,eid};
			    int update=jdbcTemplate.update(sql, params);
			    return update;
		}

		@Override
		public Employee getEmpByEid(int eid)
		{
			String sql = "SELECT eid,enm,esal from employee414 where eid=?";

			RowMapper mapper = new RowMapper() 
			{
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Employee e = new Employee(rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3));					
					System.out.println(rowNum);
					return e;
				}

			};

			Employee employee= (Employee) jdbcTemplate.queryForObject(sql,mapper,eid);
			return employee;

		}

		@Override
		public List<Employee> getEmployeeListBySal() {
			 Object[] params=new Object[]{new Double(40000.00)};
		       List list=jdbcTemplate.queryForList("SELECT * from employee414 where esl > ?",params);
		       return list;
		}

		@Override
		public List<Employee> getEmployeeList() 
		{
			String sql = "SELECT * FROM employee414";
			List<Employee> eList =jdbcTemplate.query(sql,new EmployeeRowMapper());
			return eList;
		}

}
