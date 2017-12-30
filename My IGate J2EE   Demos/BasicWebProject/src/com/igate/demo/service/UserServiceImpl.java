package com.igate.demo.service;

import java.util.ArrayList;

import com.igate.demo.dao.IUserDao;
import com.igate.demo.dao.UserDaoImpl;
import com.igate.demo.dto.LoginDTO;
import com.igate.demo.exception.LoginException;

public class UserServiceImpl  implements IUserService
{
	IUserDao userDao=new UserDaoImpl();;
	@Override
	public LoginDTO getUserInfo(String username) 
	{
		
		return userDao.getUserInfo(username);
	}
	@Override
	public ArrayList<LoginDTO> getAllUsers() 
	throws LoginException 
	{
	
		return userDao.getAllUsers();
	}

}
