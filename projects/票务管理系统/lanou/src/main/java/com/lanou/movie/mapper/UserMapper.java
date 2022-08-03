package com.lanou.movie.mapper;

import com.lanou.movie.bean.User;

import java.util.List;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 20:54
 */
public interface UserMapper {
    /** 注册用户，往用户表写入数据 */
    boolean regester(User user);
    /** 用username和password匹配数据库 */
    boolean matchUser(String username, String password);
}
