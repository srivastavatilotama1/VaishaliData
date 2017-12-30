package com.igate.dao;

import java.util.ArrayList;

import com.igate.dto.LoginDTO;
import com.igate.exception.LoginException;

public interface IUserDao 
{
	 	public ArrayList<LoginDTO> getAllUsers()throws LoginException;

	 	public LoginDTO getUserInfo(String username);
	 	public int getCount(String username);
	 	public int addUser(LoginDTO loginDto);
}
