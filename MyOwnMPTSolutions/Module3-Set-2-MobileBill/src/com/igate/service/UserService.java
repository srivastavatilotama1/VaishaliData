package com.igate.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.igate.dao.UserDao;
import com.igate.dao.UserDaoImpl;
import com.igate.dto.UserDto;
import com.igate.exception.UsersException;
import com.igate.util.DbUtil;

public class UserService
{
	public void  insertUsers(UserDto userDTO) throws UsersException
	{
		UserDao userDao=new UserDaoImpl();
		userDao.insertUsers(userDTO);
			
			
	}

	public int updateAmt(Integer amt,UserDto userDTO)throws UsersException
	{
		UserDao userDao=new UserDaoImpl();
		return userDao.updateAmt( amt, userDTO);
			
		
	}

	public ArrayList<String> getUsers()throws UsersException
	{
		UserDao userDao=new UserDaoImpl();
		return userDao.getUsers();
		
		
	}
	
	 public UserDto  getBillAmt(String username)throws UsersException
	 {
		 UserDao userDao=new UserDaoImpl();
			return userDao.getBillAmt(username);
	 }

}
