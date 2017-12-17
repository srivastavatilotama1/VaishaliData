package com.cg.dao;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cg.dto.Login;
import com.cg.dto.RegisterDto;
import com.cg.util.MyStringDateUtil;
@Repository("dao")
public class LoginDaoImpl  extends JdbcDaoSupport 
implements ILoginDao
{
	@Autowired
	javax.sql.DataSource dataSource;
	String skillSetString;

	@PostConstruct
	public void initializeDS()
	{
		setDataSource(dataSource);		
	}	

	@Override
	public boolean isValid(Login log) {		
		String qr="SELECT username,password FROM cg_user "
				+ " WHERE username=? ";		
		Login tempLogin=getJdbcTemplate().queryForObject
				(qr,new LoginRowMapper(),log.getUserName());
		System.out.println(" In dao ...."+tempLogin);		
		if(tempLogin.getUserName().equals(log.getUserName())
				&&tempLogin.getPassword().equals(log.getPassword()))
		{
			System.out.println(" returning true in isvalid....");
			return true;
		}
		else
		{
			System.out.println(" returning true in isvalid....");
			return false;		}
	}

	@Override
	public boolean isUserExist(String userId) {

		String qry="SELECT COUNT(*) FROM cg_user WHERE username=?";
		int count;
		count=getJdbcTemplate().queryForObject
				(qry,Integer.class,userId);
		if(count==1)
		{
			System.out.println(count +" ........Is User Exist  yes");
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int insertUser(Login lg) 
	{
		String inserUserQry="INSERT INTO cg_user VALUES(?,?)";
		Object[] paramUser=new Object[]{lg.getUserName(),lg.getPassword()};
		return getJdbcTemplate().update(inserUserQry,paramUser);
	}

	@Override
	public List<Login> getAllUsers() {
		String selectUserQry="SELECT * FROM cg_user";
		List<Login> validUserList =getJdbcTemplate().
				query(selectUserQry, (rs,rowNum) ->
				{
					Login lg = new Login();
					lg.setUserName(rs.getString(1));
					lg.setPassword(rs.getString(2));		
					return lg;
				});		

		System.out.println("*****************"+validUserList);
		return validUserList;
	}

	@Override
	public Login getUserDetails(String userId) 
	{

		String  dataQry="SELECT * FROM cg_user WHERE username=?";		
		return getJdbcTemplate().queryForObject(dataQry,
				new LoginRowMapper(),userId);
	}

	@Override
	public int updateUserInfo(Login userDetails) {
		System.out.println(" In Update ***********"+userDetails);
		String updateUserQry="UPDATE cg_user SET password=? WHERE  username=?";


		Object[] paramArr=new Object[]{userDetails.getPassword(),
				userDetails.getUserName()};
		return getJdbcTemplate().update(updateUserQry, paramArr);
	}

	public int insertRegisterUser(RegisterDto registerDto) {

		String inserUserQry=
				"INSERT INTO cg_userDetails VALUES(?,?,?,?,?,?,?,?)";
		
		java.sql.Date dobSqlDate=MyStringDateUtil.
				fromLocalToSqlDate(registerDto.getDobLocalDate());
		
		System.out.println(" In dao sql date is ...................."+dobSqlDate);

		//Convert skillset array to string using , separator
		
		String skillSetString=
				MyStringDateUtil.fromArrayToCommaSeparatedString
				(registerDto.getSkillSet());
		
		 String gender=new Character(registerDto.getGender()).toString();
		
		
		System.out.println("In dao skill is ..............................."+
				skillSetString);
		Object[] paramUser=new Object[]{
					registerDto.getUname(),
					registerDto.getFirstName(),
					registerDto.getLastName(),
					registerDto.getEmail(),
					skillSetString,
					registerDto.getCity(),
					gender,
					dobSqlDate};
		
		int inserted=0;
		try
		{
		 inserted= getJdbcTemplate().update(inserUserQry,paramUser);
		}
		catch(Exception e)
		{
			System.out.println("*******in catch********************");
			e.printStackTrace();
		}
		return inserted;

	}

	@Override
	public List<RegisterDto> getAllUsersDetails() {

		String selectUserDetailsQry="SELECT * FROM cg_userdetails";
		List<RegisterDto> userDetailsList =getJdbcTemplate().
				query(selectUserDetailsQry,new RegisterDtoRowMapper() );	
		return userDetailsList;
	}

	public RegisterDto getRegisterUserDetails(String un) {
		
		String  dataQry="SELECT * FROM cg_userdetails WHERE username=?";		
		return getJdbcTemplate().queryForObject(dataQry,
				new RegisterDtoRowMapper(),un);
	}

	@Override
	public int updateUserDetailsInfo(RegisterDto u) 
	{
		System.out.println(" In Update ***********"+u);
		String updateUserQry="UPDATE cg_userdetails SET  "+
		" lastname=? , email=?, skillset=?   WHERE  username=?";

		String skillSetString=
				MyStringDateUtil.fromArrayToCommaSeparatedString
				(u.getSkillSet());
		Object[] paramArr=new Object[]
				{
					u.getLastName(),
					u.getEmail(),
					skillSetString,
					u.getUname()
				};
		return getJdbcTemplate().update(updateUserQry, paramArr);
	}

	public int deleteUser(String un) {
		
		String deleteUserQuery="delete  from cg_userDetails where username=?";
		String deleteLoginQuery="delete  from cg_user where username=?";
		
		int userDeleted=getJdbcTemplate().update(deleteUserQuery, un);
		int loginDeleted=getJdbcTemplate().update(deleteLoginQuery, un);
		
		if((userDeleted==1)&&(loginDeleted==1))
			return 1;
		else		
			return 0;
	}

}
