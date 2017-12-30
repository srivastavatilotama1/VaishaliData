package com.igate.rest.util;

import java.util.ArrayList;
import java.util.List;

import com.igate.rest.bean.User;

public class StaticDBResource {

	private static List<User> userList = new ArrayList<User>();
	
	static{
		userList.add(new User(1, "Ram", "Ram123", "ram@igate.com"));
		userList.add(new User(2, "Shyam", "Shyam123", "shyam@igate.com"));
		userList.add(new User(3, "Anil", "Anil123", "anil@igate.com"));
		userList.add(new User(4, "Sunil", "sunil123", "sunil@igate.com"));
		userList.add(new User(5, "Tom", "Tom123", "tom@igate.com"));
		userList.add(new User(6, "Jerry", "Jerry123", "jerry@igate.com"));
		userList.add(new User(7, "Donald", "Donald123", "donald@igate.com"));
		userList.add(new User(8, "Kiran", "Kiran123", "Kiran@igate.com"));
		userList.add(new User(9, "Vishal", "Vishal123", "Vishal@igate.com"));
		userList.add(new User(10, "Ramlal", "Ramlal123", "ramlal@igate.com"));
		userList.add(new User(11, "Tim", "Tim123", "tim@igate.com"));
		userList.add(new User(12, "Zim", "Zim123", "zim@igate.com"));
	}
	
	public static List<User> getAllUsers(){
		return userList;
	}
	
}
