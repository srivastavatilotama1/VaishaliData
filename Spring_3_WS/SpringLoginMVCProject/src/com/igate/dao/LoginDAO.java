package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Login;

public class LoginDAO  implements ILoginDAO
{

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public LoginDAO(JdbcTemplate jdbcTemplate) 
	{
		super();
		this.jdbcTemplate = jdbcTemplate;		
	}
	@Override
	public void insertLogin(Login login)
	{
		String query = "INSERT INTO login(email, password) VALUES (?,?)";
		jdbcTemplate.update(query, new Object[] { Integer.valueOf(login.getUserName()), 
				login.getPassword() });
	}
	@Override
	public int getLoginCount() {
		int count=0;
		count=jdbcTemplate.queryForInt("select count(*) from login");
		return count;
	}

	@Override
	public String getLoginPassword(String email)
	{
		String sql = "SELECT password  from login where email=?";
		String password=jdbcTemplate.queryForObject(sql,String.class,email);
		return password;
	}
	
	public Login getLogin(String email)throws EmptyResultDataAccessException
	{
		String sql = "SELECT email,password from login where email=?";
		Login loginObj=(Login)jdbcTemplate.queryForObject(sql,new LoginRowMapper(),email);
		System.out.println("****************************"+loginObj);
		return loginObj;
		
	}

	@Override
	public int updatePassword(String email, String pwd) 
	{
		String sql="update login set password=? where email=?";
		Object[] params = new Object[]{pwd,email};
		int update=jdbcTemplate.update(sql, params);
		return update;
	}

	@Override
	public ArrayList<Login> getAllLogins() 
	{
		String sql = "SELECT * FROM login";
		List<Login> lList =jdbcTemplate.query(sql,new LoginRowMapper());
		return (ArrayList<Login>) lList;
	}
	
}
