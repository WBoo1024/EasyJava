package com.lanou.movie.controller;

import com.lanou.movie.bean.User;
import com.lanou.movie.service.UserService;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 20:53
 */
public class UserController {
    private UserService userService;
    public UserController(){
        this.userService = new UserService();
    }

    public boolean regester(User user){
        return userService.regester(user);
    }

    public boolean matchUser(String username, String password) {
        return userService.matchUser(username, password);
    }
}
