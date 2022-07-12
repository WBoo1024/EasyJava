package com.lanou.student.page;

import java.util.Scanner;

import com.lanou.student.bean.User;
import com.lanou.student.controller.UserController;
import com.lanou.student.util.PasswordUtil;

public class Reset {
	
	private Scanner sca = new Scanner(System.in);
	private UserController userController;
	public Reset(UserController userController) {
		this.userController = new UserController();
	}
	public boolean resetPassword() {
		System.out.println("请输入注册的邮箱地址");
		String eamil = sca.next();
		User u = userController.getUser(null, eamil);
		if (u == null) {
			System.out.println("邮箱未注册");
			return false;
		}
		u.setPassWord(PasswordUtil.md5("123456",u.getUserName()));
		System.out.println("密码重置为：123456");
		return true;
	}
}
