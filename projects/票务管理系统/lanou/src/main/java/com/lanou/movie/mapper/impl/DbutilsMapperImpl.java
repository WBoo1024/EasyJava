package com.lanou.movie.mapper.impl;

import com.lanou.movie.bean.User;
import com.lanou.movie.mapper.DbutilsMapper;
import com.lanou.movie.util.DataUtil;
import com.lanou.movie.util.PasswordUtil;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 09:47
 */
public class DbutilsMapperImpl extends BaseUserDao implements DbutilsMapper{
    @Override
    public  int add(User user) {
        String sql = "insert into user(userName,password,reTime,phone,email) values(?,?,?,?,?)";
        try {
            Date date = DateUtils.parseDate(user.getReTime(),"yy-MM-dd");
            return runner.update(sql,user.getUsername(), PasswordUtil.md5(user.getUsername(),user.getPassword()),date,user.getPhone(),user.getEmail());
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<String> getUsername() {
        String sql = "select username from user";
        try {
            return runner.query(sql,new ColumnListHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> loginMatch(String username,String password) {
        String sql = "select * from user where username = ? and password = ?";
        return DataUtil.getDataByparams(sql,DbutilsMapperImpl.class,username,password);
    }


}
