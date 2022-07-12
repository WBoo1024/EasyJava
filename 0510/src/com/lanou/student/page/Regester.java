package com.lanou.student.page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lanou.student.bean.User;
import com.lanou.student.controller.UserController;
import com.lanou.student.util.PasswordUtil;

public class Regester {
	private Scanner sca = new Scanner(System.in);
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private UserController userController;
	
	public Regester(UserController userController) {
		this.userController = userController;
	}
	public Regester() {
		
	}
	public boolean checkName(String name) {
		String regExp = "^[^0-9][\\w_]{6,10}$";
		if (name.matches(regExp)) {
			return true;
		}
		return false;
	}
	public boolean checkPwd(String password) {
		String regExp = "^[^0-9][\\w]{6,10}$";
		if (password.matches(regExp)) {
			return true;
		}
		return false;
	}
	public boolean checkEamil(String eamil) {
		String regExp = "^[\\w]{4,}@qq.com$";
		if (eamil.matches(regExp)) {
			return true;
		}
		return false;
	}
	public boolean checkPhone(String phone) {
		String regExp = "^[1][0-9]{10,12}$";
		if (phone.matches(regExp)) {
			return true;
		}
		return false;
	}
	
	public boolean regester() {
		User user = getUser();
		return userController.regester(user);
	}
	
	public User getUser() {
			System.out.println("请输入用户名");
			String userName = sca.next();
			//校验用户名格式是否合法
			while (!checkName(userName)) {
				System.out.println("用户名不合法，请重新输入");
				userName = sca.next();
			}
			//校验用户名是否重复
			while (userController.getUser(userName,null) != null) {
				System.out.println("该用户名已被注册，请重新输入");
				userName = sca.next();
			}
			
			System.out.println("请输入密码");
			String password = sca.next();
			while (!checkPwd(password)) {
				System.out.println("密码不合法，请重新输入");				
				password = sca.next();
			}
			String newPass = PasswordUtil.md5(password,userName);
			System.out.println("请输入邮箱地址");
			String eamil = sca.next();
			while (!checkEamil(eamil)) {
				System.out.println("邮箱不合法，请重新输入");				
				eamil = sca.next();
			}
			System.out.println("请输入联系方式");
			String phone = sca.next();
			while (!checkPhone(phone)) {
				System.out.println("手机号不合法，请重新输入");				
				phone = sca.next();
			}
			System.out.println("是否是管理员");
			boolean isRoot = sca.nextBoolean();
			
			String creatTime = sdf.format(new Date());
			return new User(userName,newPass,eamil,phone,creatTime,isRoot);
	}
	
	public boolean logout(String name) {
		
		return userController.logout(name);
	}
	
}
