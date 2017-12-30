package com.igate.auction.dao;

import java.util.ArrayList;

import com.igate.auction.dto.LoginDTO;
import com.igate.auction.exception.LoginException;


public interface IUserDao 
{
	public com.igate.auction.dto.LoginDTO getUserInfo(String username);
	public ArrayList<LoginDTO> getAllUsers()throws 
	LoginException;
	public ArrayList<String> getAllUsersName()
	throws LoginException;
	public int changePassword(String userName)
	throws LoginException;
	
	public int addUserInfo(LoginDTO loginDto)
	throws LoginException;
	public boolean isValidUser(LoginDTO loginDto) ;
}
