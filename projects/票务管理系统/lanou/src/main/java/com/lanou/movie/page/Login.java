package com.lanou.movie.page;

import com.lanou.movie.controller.UserController;
import com.lanou.movie.util.PasswordUtil;

import java.util.Scanner;

/**
 * @program: lanou
 * @description: 登陆账号
 * @author: 壹零二四
 * @created: 2022/07/11 21:08
 */
public class Login {
    private UserController userController;
    private Scanner scanner = new Scanner(System.in);

    public Login(UserController userController) {
        this.userController = userController;
    }

    public Login() {
    }

    public boolean login() {
        System.out.println("-----登陆界面------");
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = PasswordUtil.md5(username,scanner.next());
        boolean match = userController.matchUser(username,password);
        return false;
    }
}
