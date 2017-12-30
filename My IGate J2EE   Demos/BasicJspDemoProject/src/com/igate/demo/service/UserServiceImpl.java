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
	@Override
	public ArrayList<String> getAllUsersName()
	throws LoginException {
		
		return userDao.getAllUsersName();
	}
	@Override
	public int changePassword(String userName) throws LoginException {
	
		return 0;
	}
	@Override
	public int addUserInfo(LoginDTO loginDto) throws LoginException {
	
		return userDao.addUserInfo(loginDto);
	}
	@Override
	public boolean isValidUser(LoginDTO loginDto)throws 
	LoginException
	{		
		ArrayList<LoginDTO> usersList=
			userDao.getAllUsers();
		System.out.println(" In Service isValid User Method "+
				usersList);		
		boolean valid=false;
		for(LoginDTO tempLoginDto:usersList)
		{
			if(tempLoginDto.getUserName().
					equals(loginDto.getUserName())&&
					(tempLoginDto.getPassword().equals
							(loginDto.getPassword())))
			{
				System.out.println(" Valid ....");
				valid=true;
				break;
			}
			else
			{
				System.out.println(" Not Valid ....");
				valid= false;				
			}
		}		
		return valid;
	}

}
