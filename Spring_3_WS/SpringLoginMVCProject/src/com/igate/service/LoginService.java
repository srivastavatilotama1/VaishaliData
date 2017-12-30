package com.igate.service;

import java.util.ArrayList;
import java.util.List;
import com.igate.bean.Login;

public interface LoginService 
{	
	public ArrayList<Login> getAllLogins();
	public void insertLogin(Login login);
	public int getLoginCount();
	public String getLoginPassword(String email);
	public int updatePassword(String email, String pwd) ;
	public Login getLogin(String email);


}
