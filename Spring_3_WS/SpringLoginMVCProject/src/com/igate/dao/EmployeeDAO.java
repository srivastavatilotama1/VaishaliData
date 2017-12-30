package com.igate.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.igate.bean.Employee;

@Component(value="empDAO")
public class EmployeeDAO implements IEmployeeDAO
{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(JdbcTemplate jdbcTemplate) 
	{
		super();
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public boolean insertEmployee(Employee employee)
	{
		String prefLang=(employee.getPrefLanguages())[0];
		System.out.println("language is :"+prefLang);
		java.util.Date utilDOB=employee.getJoinedDate();
		System.out.println("Util DOB"+utilDOB);
		GregorianCalendar calDOB= new GregorianCalendar(utilDOB.getYear(),
				utilDOB.getMonth(),utilDOB.getDate());
		java.sql.Date sqlDOB=new java.sql.Date((calDOB.getTime().getTime()));
		System.out.println("In Emp  Dao......."+sqlDOB);
		
		String insertEmp ="insert into IEmp VALUES(?,?,?,?,?,?,?,?)";
        
		Object [] objParam=new Object[]{employee.getEid(),
				employee.getFirstName(),employee.getLastName(),
				employee.getCity(),prefLang,
				employee.getMaritalStaus(),employee.getSalary(),
				sqlDOB};

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

	@Override
	public int getEmpCount() {
		int count=0;
		count=jdbcTemplate.queryForInt("select count(*) from IEMP");
		return count;
	}

	@Override
	public String getEmployeeName(int eid) {
		String sql = "SELECT firstname from iemp where empno=?";
		String name=jdbcTemplate.queryForObject(sql,String.class,eid);
		return name;
	}

	@Override
	public int updateEmp(Employee emp) 
	{
      System.out.println(" In edit emp....dao......"+emp);
		String sql="update iemp set "+
		"  efirstname=?,elastname=?,city=?,salary=?,MARRITAL_STATUS=?"+
		" where empno=?";
		Object[] params = new Object[]
		      {
				emp.getFirstName(),
				emp.getLastName(),
				emp.getCity(),
				emp.getSalary(),
				emp.getMaritalStaus(),
				emp.getEid()};
		int update=jdbcTemplate.update(sql, params);
		return update;
	}

	@Override
	public Employee getEmpByEid(int eid)
	{
		String sql = "SELECT * from iemp where empno=?";

		RowMapper mapper = new RowMapper() 
		{
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				java.util.Date utilDOB=new
				java.util.Date((rs.getDate("DOJ").getTime()));
				
				
				String langArr[]=new String[1];
				langArr[0]=rs.getString("PREF_LANG");
				
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setCity(rs.getString(4));
				
				e.setPrefLanguages(langArr);
				e.setMaritalStaus(rs.getString(6));
				e.setSalary(rs.getInt("salary"));
				e.setJoinedDate(utilDOB);
				
				
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
		List list=jdbcTemplate.queryForList("SELECT * from iemp where salary>=?",params);
		return list;
	}

	@Override
	public List<Employee> getEmployeeList() 
	{
		String sql = "SELECT * FROM iemp";
		List<Employee> eList =jdbcTemplate.query(sql,new EmployeeRowMapper());
		System.out.println(" Get Emp List DAo "+eList);
		return eList;
	}

}
