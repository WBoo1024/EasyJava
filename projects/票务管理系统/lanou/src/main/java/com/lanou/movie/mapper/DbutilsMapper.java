package com.lanou.movie.mapper;

import com.lanou.movie.bean.User;

import java.util.List;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 21:56
 */
public interface DbutilsMapper {
    /** 单条数据添加成功，返回修改的行数 */
    int add(User user);
    /** 查询username字段所有数据 */
    List<String> getUsername();
    /** 查询username及对应的password */
    List<User> loginMatch(String username,String password);
}
