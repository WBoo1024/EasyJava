package com.lanou.student.service;

import com.lanou.student.bean.User;
import com.lanou.student.mapper.UserMapper;

public class UserService {
	private UserMapper userMapper;
	public UserService() {
		userMapper = new UserMapper();
	}
	public boolean regester(User user) {
		return userMapper.regester(user);
	}
	public User getUser(String userName, String eamil) {
		return userMapper.getUser(userName,eamil);
		
	}
	public boolean logout(String next) {
		return userMapper.logout(next);
	}
	
}
