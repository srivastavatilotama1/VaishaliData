package com.igate.dao;

import java.util.ArrayList;

import com.igate.bean.Login;

public interface ILoginDAO 
{
	public ArrayList<Login> getAllLogins();
	public void insertLogin(Login login);
	public Login getLogin(String email);
	public int getLoginCount();
	public String getLoginPassword(String email);
	public int updatePassword(String email, String pwd) ;

}
