package com.igate.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igate.rest.bean.User;
import com.igate.rest.bean.UserList;
import com.igate.rest.dao.UserDAO;

@Controller
public class UserServiceController {

	private UserDAO dao = new UserDAO();

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUserById(@PathVariable("id") int id) {
		System.out.println(dao.getUserById(id));
		return dao.getUserById(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody
	UserList getAllUsers() {
		List<User> users = dao.getAllUsers();
		UserList userList = new UserList();
		userList.setList(users);
		return userList;
	}

	@RequestMapping(value = "/deluser/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	User deleteUser(@PathVariable("id") int id) {
		return dao.deleteUser(id);
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody
	User addUser(@RequestBody User user) {
		dao.addUser(user);
		return user;
	}
	
	
}
