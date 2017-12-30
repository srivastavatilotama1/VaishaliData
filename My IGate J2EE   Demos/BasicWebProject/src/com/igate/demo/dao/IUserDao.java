package com.igate.demo.dao;

import java.util.ArrayList;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.exception.LoginException;

public interface IUserDao 
{
	 	public ArrayList<LoginDTO> getAllUsers()throws LoginException;

	 	public LoginDTO getUserInfo(String username);
}
