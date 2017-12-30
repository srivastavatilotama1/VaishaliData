package com.igate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.igate.bean.Login;
import com.igate.dao.ILoginDAO;

public class LoginServiceImpl  implements LoginService
{
	ILoginDAO loginDao;
	
	public ILoginDAO getLoginDao() 
	{
		return loginDao;
	}
	public void setLoginDao(ILoginDAO loginDao) 
	{
		this.loginDao = loginDao;
	}
	public ArrayList<Login> getAllLogins()
	{
		return loginDao.getAllLogins();
		
	}
	public Login getLogin(String email)throws EmptyResultDataAccessException
	{
		return loginDao.getLogin(email);
	}
	public void insertLogin(Login login){}
	public int getLoginCount(){return 0;}
	public String getLoginPassword(String email){return loginDao.getLoginPassword(email);}
	public int updatePassword(String email, String pwd) {return 0;}


}
