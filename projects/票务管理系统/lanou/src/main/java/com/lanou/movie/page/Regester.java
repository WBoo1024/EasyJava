package com.lanou.movie.page;

import com.lanou.movie.bean.User;
import com.lanou.movie.controller.UserController;
import com.lanou.movie.mapper.impl.RegesterCheckMapperImpl;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.Scanner;

/**
 * @program: lanou
 * @description: 注册账号
 * @author: 壹零二四
 * @created: 2022/07/11 21:09
 */
public class Regester {
    private static  Scanner scanner = new Scanner(System.in);
    private static final RegesterCheckMapperImpl checkImpl = new RegesterCheckMapperImpl();
    private  UserController userController;
    public Regester(UserController userController){
        this.userController = userController;
    }
    public Regester(){}

    public static User getUser(){
        System.out.println("请输入用户名");
        String username = scanner.next();
        //校验用户名格式是否合法
        while (!checkImpl.checkName(username)){
            System.out.println("用户名不合法，请重新输入");
            username = scanner.next();
        }
        //校验用户名是否已经存在
        while (!checkImpl.hasExists(username)){
            System.out.println("用户名重复，请重新输入");
            username = scanner.next();
        }
        System.out.println("请输入密码");
        String password = scanner.next();
        //校验密码合法性
        while (!checkImpl.checkPassword(password)) {
            System.out.println("密码不合法，请重新输入");
            password = scanner.next();
        }
        //重复验证密码正确性
        System.out.println("请再输入一次密码");
        String rePassword = scanner.next();
        while (!password.equals(rePassword)) {
            System.out.println("密码错误，请再次输入");
            rePassword = scanner.next();
        }
        //校验手机号
        System.out.println("请输入绑定的手机号");
        String phone = scanner.next();
        while (!checkImpl.checkPhone(phone)) {
            System.out.println("手机号不合法，请重新输入");
            phone = scanner.next();
        }
        //校验邮箱
        System.out.println("请输入邮箱");
        String email = scanner.next();
        while (!checkImpl.checkEmail(email)) {
            System.out.println("邮箱不合法，请重新输入");
            email = scanner.next();
        }
        //Date将当前时间转化为字符串
        String reTime = DateFormatUtils.format(new Date(),"yyyy-MMM-dd");
        return new User(username,password,reTime,phone,email);
    }

    public boolean regester(){
        User user = getUser();
        return userController.regester(user);
    }
}
