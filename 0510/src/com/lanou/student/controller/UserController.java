package com.lanou.student.controller;

import com.lanou.student.bean.User;
import com.lanou.student.mapper.UserMapper;
import com.lanou.student.service.UserService;

public class UserController {
	private UserService userService;
	public UserController() {
		userService = new UserService();
	}
	
	public boolean regester(User user) {
		return userService.regester(user);
	}

	public User getUser(String userName, String eamil) {
		return userService.getUser(userName,eamil);
	}

	public boolean logout(String next) {
		return userService.logout(next);
	}
	
}
