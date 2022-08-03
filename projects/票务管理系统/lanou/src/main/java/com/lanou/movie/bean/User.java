package com.lanou.movie.bean;

import lombok.Data;

/**
 * @program: lanou
 * @description: 票务系统用户管理
 * @author: 壹零二四
 * @created: 2022/07/11 20:40
 */
@Data
public class User {
    /** 用户uid（自增） */
    private String uid;
    /** 用户名（唯一） */
    private String username;
    /** 用户密码 */
    private String password;
    /** 注册时间（日期） */
    private String reTime;
    /** 手机号码 */
    private String phone;
    /** 邮箱 */
    private String email;
    public User(String username,String password,String reTime,String phone,String email) {
        this.username = username;
        this.password = password;
        this.reTime = reTime;
        this.phone = phone;
        this.email = email;
    }

    public User(String uid, String username, String password, String reTime, String phone, String email) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.reTime = reTime;
        this.phone = phone;
        this.email = email;
    }
}
