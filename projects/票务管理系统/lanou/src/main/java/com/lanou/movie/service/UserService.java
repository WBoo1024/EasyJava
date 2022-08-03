package com.lanou.movie.service;

import com.lanou.movie.bean.User;
import com.lanou.movie.mapper.UserMapper;
import com.lanou.movie.mapper.impl.UserMapperImpl;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 20:53
 */
public class UserService {
    private UserMapperImpl userMapperImpl;
    public UserService(){
        userMapperImpl = new UserMapperImpl();
    }

    public boolean regester(User user) {
        return userMapperImpl.regester(user);
    }

    public boolean matchUser(String username, String password) {
        return userMapperImpl.matchUser(username, password);
    }
}
