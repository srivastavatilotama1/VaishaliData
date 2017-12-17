package com.cg.service;
import java.util.List;

import com.cg.dto.Login;
import com.cg.dto.RegisterDto;
public interface ILoginService
{
	public boolean isValid(Login log);
	public  boolean isUserExist(String userId);
	public int insertUser(Login lg);
	public List<Login> getAllUsers();
	public Login getUserDetails(String userId) ;
	public int updateUserInfo(Login userDetails);
	public int insertRegisterUser(RegisterDto registerDto);
	public List<RegisterDto> getAllUsersDetails();
	public RegisterDto getRegisterUserDetails(String un);
	public int updateUserDetailsInfo(RegisterDto u);
	public int deleteUser(String un);
}
