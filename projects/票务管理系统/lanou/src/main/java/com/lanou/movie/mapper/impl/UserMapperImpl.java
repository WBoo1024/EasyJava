package com.lanou.movie.mapper.impl;

import com.lanou.movie.bean.User;
import com.lanou.movie.mapper.DbutilsMapper;
import com.lanou.movie.mapper.UserMapper;

import java.util.List;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 09:25
 */
public class UserMapperImpl implements UserMapper {
    private DbutilsMapperImpl dbm;
    @Override
    public boolean regester(User user) {
        dbm = new DbutilsMapperImpl();
        int num= dbm.add(user);
        return num == 1;
    }

    @Override
    public boolean matchUser(String username, String password) {
        dbm = new DbutilsMapperImpl();
        List<User> list = dbm.loginMatch(username, password);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }
}
