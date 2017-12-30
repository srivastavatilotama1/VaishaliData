package com.igate.auction.service;

import com.igate.auction.dao.IUserDao;
import com.igate.auction.dao.UserDaoImpl;
import com.igate.auction.dto.LoginDTO;
import com.igate.auction.exception.LoginException;

public class UserServiceImpl implements IUserService
{
	IUserDao userDao=new UserDaoImpl();
	@Override
	public boolean isValidUser(LoginDTO loginDto) throws LoginException 
	{
		
		return userDao.isValidUser(loginDto);
	}

}
