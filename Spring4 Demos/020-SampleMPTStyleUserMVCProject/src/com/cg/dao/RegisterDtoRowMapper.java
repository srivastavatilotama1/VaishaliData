package com.cg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.cg.dto.Login;
import com.cg.dto.RegisterDto;
import com.cg.util.MyStringDateUtil;



public class RegisterDtoRowMapper implements RowMapper<RegisterDto>
{
	@Override
	public RegisterDto mapRow(ResultSet rs, int arg1) throws SQLException 
	{	
		System.out.println("  In Register mapper...................................");
		RegisterDto registerDto=new RegisterDto();
		registerDto.setCity(rs.getString("city"));
		registerDto.setUname(rs.getString("username"));
		registerDto.setEmail(rs.getString("email"));
		registerDto.setFirstName(rs.getString("firstname"));
		registerDto.setLastName(rs.getString("lastname"));		
		registerDto.setGender(rs.getString("gender").charAt(0));		
		registerDto.setDobLocalDate(MyStringDateUtil.
				fromSqlToLocalDate(rs.getDate("dob")));		
		registerDto.setSkillSet(
				MyStringDateUtil.fromArrayListToArray(
					(MyStringDateUtil.fromStringToArrayList(rs.getString("skillset")))
						));		
		registerDto.setSkillSetStr(rs.getString("skillset"));
		
		return registerDto;
	}

}
