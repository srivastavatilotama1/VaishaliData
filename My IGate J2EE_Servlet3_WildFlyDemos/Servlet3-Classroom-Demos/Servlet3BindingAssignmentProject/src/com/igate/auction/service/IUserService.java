package com.igate.auction.service;

import java.util.ArrayList;

import com.igate.auction.dto.LoginDTO;
import com.igate.auction.exception.LoginException;

public interface IUserService {
	
	public boolean isValidUser(LoginDTO loginDto) throws LoginException;

}
