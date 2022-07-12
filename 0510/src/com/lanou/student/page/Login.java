package com.lanou.student.page;

import java.util.Objects;

import com.lanou.student.controller.TicketingSystemController;
import com.lanou.student.controller.UserController;
import com.lanou.student.util.CaptchaCode;
import com.lanou.student.util.PasswordUtil;
import java.util.Scanner;
import com.lanou.student.bean.User;

public class Login {
	private UserController userController;
	private Index index;
	private Scanner sca = new Scanner(System.in);
	
	public Login(UserController userController) {
		this.userController = userController;
		index = new Index(new TicketingSystemController());
	}
	public Login() {
		
	}
	
	public void login() {
		System.out.println("-----登陆界面------");
		System.out.println("请输入用户名");
		String userName = sca.next();
		System.out.println("请输入密码");
		String password = PasswordUtil.md5(sca.next(),userName);
		System.out.println("请输入验证码");
		String s = CaptchaCode.getCode();
		String code = sca.next();
		
		User u = userController.getUser(userName, null);
		if (null == u) {
			System.out.println("用户名输入错误");
			return;
		}
		if (!Objects.equals(password, u.getPassWord())) {
			System.out.println("密码输入错误");
			return;
		}
		if (!Objects.equals(s, code)) {
			System.out.println("验证码输入错误");
			return;
		}
		index.index();
	}
	
}
