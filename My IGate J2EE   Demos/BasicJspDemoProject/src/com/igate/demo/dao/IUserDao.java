package com.igate.demo.dao;

import java.util.ArrayList;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.exception.LoginException;

public interface IUserDao 
{
	public LoginDTO getUserInfo(String username);
	public ArrayList<LoginDTO> getAllUsers()throws 
	LoginException;
	public ArrayList<String> getAllUsersName()
	throws LoginException;
	public int changePassword(String userName)
	throws LoginException;
	
	public int addUserInfo(LoginDTO loginDto)
	throws LoginException;
}
