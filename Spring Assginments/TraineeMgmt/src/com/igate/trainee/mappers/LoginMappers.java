package com.igate.trainee.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.trainee.beans.Login;

public class LoginMappers implements RowMapper<Login>{

	public Login mapRow(ResultSet rs, int arg1) throws SQLException {
		Login loginDetails=new Login();
		loginDetails.setUsername(rs.getString(1));
		loginDetails.setPassword(rs.getString(2));
		return loginDetails;
	}
}
