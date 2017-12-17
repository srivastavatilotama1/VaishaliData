package com.cg.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoginDaoImpl;
import com.cg.dto.Login;
import com.cg.dto.RegisterDto;
@Service("loginService")
public class LoginServiceImpl implements 
ILoginService 
{
	@Autowired
	LoginDaoImpl dao;
	
	public LoginDaoImpl getDao() 
	{
		return dao;
	}
	public void setDao(LoginDaoImpl dao) 
	{
		this.dao = dao;	}
	@Override
	public boolean isValid(Login log)
	{	
		return dao.isValid(log);
	}
	@Override
	public boolean isUserExist(String userId) {
	
		return dao.isUserExist(userId);
	}
	@Override
	public int insertUser(Login lg) {
		// TODO Auto-generated method stub
		return dao.insertUser(lg);
	}
	@Override
	public List<Login> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}
	@Override
	public Login getUserDetails(String userId) {		
		return dao.getUserDetails(userId);
	}
	@Override
	public int updateUserInfo(Login userDetails) {
	
		return dao.updateUserInfo(userDetails);
	}
	
	
	@Override
	public int insertRegisterUser(RegisterDto registerDto) 
	{
		System.out.println("registerDto................");
		LocalDate dobDate=LocalDate.parse(
				registerDto.getDobDateText(),
				DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		registerDto.setDobLocalDate(dobDate);
				return dao.insertRegisterUser(registerDto);
	}
	@Override
	public List<RegisterDto> getAllUsersDetails()
	{
			return dao.getAllUsersDetails();
	}
	@Override
	public RegisterDto getRegisterUserDetails(String un) {
		
		return dao.getRegisterUserDetails(un);
	}
	@Override
	public int updateUserDetailsInfo(RegisterDto u) {
		// TODO Auto-generated method stub
		return dao.updateUserDetailsInfo(u);
	}
	@Override
	public int deleteUser(String un) {
		// TODO Auto-generated method stub
		return dao.deleteUser(un);
	}
}
