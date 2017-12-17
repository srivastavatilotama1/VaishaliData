package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;

public interface ILoginDao 
{
	public Login getUserByUserName(String un);

	public boolean isValid(String un);
	public boolean isUserExist(String un);	
	public RegisterDto addAllUserDeatils(RegisterDto regDto);
	public Login addUser(Login log);
	public ArrayList<RegisterDto> getAllUserDetails();
	public RegisterDto getRegisterUserDetails(String un);
	public void updateUserDetailsInfo(RegisterDto u);
	public void updateUserInfo(Login lg);
}
