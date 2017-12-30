package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Login;


public class LoginRowMapper implements RowMapper
{

	public Object mapRow(ResultSet rs, int rowcount) throws SQLException {
		System.out.println("Row Count In LogIn Row mapper Is *************"+rowcount);
		Login log= new Login(
				rs.getString("email"),
				rs.getString("password"));		
		return log;
		
}
}
