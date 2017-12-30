package com.igate.dao;


import java.util.ArrayList;
import java.util.HashMap;


import com.igate.dto.UserDto;
import com.igate.exception.UsersException;

public interface UserDao 
{
	public void insertUsers(UserDto userDTO) throws UsersException;

	 public int updateAmt(Integer amt,UserDto userDTO)throws UsersException;
	 
	 public ArrayList<String> getUsers()throws UsersException;
	 
	 public UserDto  getBillAmt(String username)throws UsersException;

}
