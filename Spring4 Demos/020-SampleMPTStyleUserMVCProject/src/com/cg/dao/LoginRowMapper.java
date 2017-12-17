package com.cg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.cg.dto.Login;



public class LoginRowMapper implements RowMapper<Login>
{
	@Override
	public Login mapRow(ResultSet rs, int arg1) throws SQLException 
	{	
		Login lg=new Login();
			lg.setUserName(rs.getString(1));
			lg.setPassword(rs.getString(2));
			return lg;
	}

}
