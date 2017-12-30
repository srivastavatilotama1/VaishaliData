package com.igate.basic.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.igate.dao.IUserDao;
import com.igate.dao.UserDaoImpl;
import com.igate.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport implements SessionAware
{
	private String userName;
	private String password;	
	Map<String, Object> session_map;
	
	IUserDao userDao=new UserDaoImpl();
	 ArrayList<LoginDTO> userNamelist=null;
	
	 public String populate() 
	 {
		 System.out.println(" Populate Method Excecuted...............");
		 userNamelist=userDao.getAllUsers();
			
		return "populate";
		}
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public ArrayList<LoginDTO> getUserNamelist() {
		return userNamelist;
	}
	public void setUserNamelist(ArrayList<LoginDTO> userNamelist) {
		this.userNamelist = userNamelist;
	}
	public String execute() 
	{
		System.out.println(" In Login Action  Execute UserName Is :   "+userName);
		System.out.println(" In Login Action   Execute:  Password is  "+password);
		session_map.put("username", userName);
		int count=userDao.getCount(userName);
		if(count!=0)
		{	
			System.out.println(" Count Is : "+count);
			LoginDTO loginDto=userDao.getUserInfo(userName);
			
			if(loginDto.getUserName().equalsIgnoreCase(userName)&&
					(loginDto.getPassword().equalsIgnoreCase(password)))
			{
				return "successLogin";
			}
			else
			{
				return "errorLogin";
			}
		}
		else
		{
			return "userNotExists";
		}
	}
	
	public String getUserName() 
	{
	//	System.out.println(userName);
		return userName;
		} 
	public void setUserName(String userName) {this.userName = userName;	}
	public String getPassword() {return password	;}
	public void setPassword(String password) {this.password = password;	}
	@Override
	public void setSession(Map<String, Object> dataMap) {
		this.session_map=dataMap;
		
	}
	
	
}