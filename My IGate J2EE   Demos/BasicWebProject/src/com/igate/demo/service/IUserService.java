package com.igate.demo.service;

import java.util.ArrayList;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.exception.LoginException;

public interface IUserService 
{
	public LoginDTO getUserInfo(String username);
	public ArrayList<LoginDTO> getAllUsers()throws 
	LoginException;

}
