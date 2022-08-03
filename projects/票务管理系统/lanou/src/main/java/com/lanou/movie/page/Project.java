package com.lanou.movie.page;

import com.lanou.movie.controller.UserController;

import java.util.Scanner;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 20:59
 */
public class Project {

    private Regester regester = new Regester();
    public Project(UserController userController) {

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------蓝鸥影院票务管理系统---------");
            System.out.println();
            System.out.println("\t\t1.登陆\t\t2.注册");
            System.out.println();
            System.out.println("\t\t3.忘记密码\t4.退出");
            System.out.println();
            switch (scanner.nextInt()) {
//                case 1:
//                    login.login();
//                    break;
                case 2:
                    if (regester.regester()) {
                        System.out.println("注册成功");
//                        login.login();
                    } else {
                        System.out.println("注册失败");
                    }
                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("不存在的指令，请正确输入");
                    break;
            }
        }
    }
}
