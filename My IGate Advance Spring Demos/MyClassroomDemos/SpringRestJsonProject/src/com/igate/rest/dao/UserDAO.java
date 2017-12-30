package com.igate.rest.dao;

import java.util.List;

import com.igate.rest.bean.User;
import com.igate.rest.util.StaticDBResource;
public class UserDAO {

	public List<User> getAllUsers() {
		return StaticDBResource.getAllUsers();
	}

	public User getUserById(int id) {
		User user = null;
		List<User> userList = StaticDBResource.getAllUsers();
		for (User usr : userList) {
			if (usr.getUserid() == id) {
				user = usr;
				break;
			}
		}
		return user;
	}

	public void addUser(User user) {
		StaticDBResource.getAllUsers().add(user);
	}

	public User deleteUser(int id) {
		System.out.println("Reached.............."+id);
		List<User> userList = StaticDBResource.getAllUsers();
		for (User user : userList) {
			if (user.getUserid() == id) {
				userList.remove(user);
				return user;
			}
		}
		return null;
	}
}
