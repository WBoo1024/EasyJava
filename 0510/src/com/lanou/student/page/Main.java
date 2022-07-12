package com.lanou.student.page;

import com.lanou.student.controller.UserController;

/**
 * @author WANG
 */
public class Main {
	public static void main(String[] args) {
		UserController userController = new UserController();
		Project protect = new Project(userController);
		protect.start();
	}
}
