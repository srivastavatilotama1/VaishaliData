package com.igate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import com.igate.dto.Login;
import com.igate.dto.User;

@Component("dao")
public class UserDao {
	
	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;
	
	public boolean validate(Login login)
	{
		boolean userPresent=false;
		
		String sql = "SELECT count(*) from Login414 where username=? AND password=?";
		int count=(int)simpleJdbcTemplate.queryForInt(sql,login.getUserName(),login.getPassword());
		if(count==1)
		  userPresent=true;
		else
	      userPresent=false;		
			
		return userPresent;
	}
	
	public int insertRec(User user)
	{
	    String skills="";
	    for(String skl:user.getSkillSet())
	    {
	    	skills=skills+skl+" ";
	    }
	    skills=skills.trim();
	    
	    String sql1="insert into user414 values(?,?,?,?,?)";
	    Object[] params=new Object[]{user.getUserName(),Character.toString(user.getGender()),user.getEmail(),skills,user.getCity()};
	    simpleJdbcTemplate.update(sql1,params);
	    
	    String sql2="insert into login414 values(?,?)";
		params=new Object[]{user.getUserName(),user.getPassword()};
		return simpleJdbcTemplate.update(sql2, params);
		
	}
}
