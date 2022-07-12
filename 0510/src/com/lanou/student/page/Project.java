package com.lanou.student.page;

import java.util.Scanner;

import com.lanou.student.controller.UserController;

public class Project {
	private Regester regester;
	private Login login;
	private Reset reset;
	
	public Project() {
		
	}
	public Project(UserController userController) {
		regester = new Regester(userController);
		reset = new Reset(userController);
		login = new Login(userController);
	}
	public void start() {
		Scanner sca = new Scanner(System.in);
		while (true) {
			System.out.println("---------蓝鸥影院票务管理系统---------");
			System.out.println();
			System.out.println("\t\t1.登陆\t\t2.注册");
			System.out.println();
			System.out.println("\t\t3.忘记密码\t4.退出");
			System.out.println();
			switch (sca.nextInt()) {
			case 1:
				//登陆
				login();
				break;
			case 2:
				//注册
				if(regester.regester()) {
					System.out.println("注册成功");
					login.login();
				}else {
					System.out.println("注册失败");
				}
				break;
			case 3:
				//忘记密码
				if (reset.resetPassword()) {
					login.login();
				}else {
					System.out.println("密码重置失败");
				}
				break;
			case 4:
				//退出
				System.exit(0);
				break;
			default:
				System.out.println("选择有误，请重新选择");
				break;
			}
		}
		
	}
	private void login() {
		login.login();
	}
	
}
