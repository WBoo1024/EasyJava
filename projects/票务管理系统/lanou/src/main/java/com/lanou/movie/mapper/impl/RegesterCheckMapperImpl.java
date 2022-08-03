package com.lanou.movie.mapper.impl;

import com.lanou.movie.mapper.RegesterCheckMapper;

import java.util.List;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 10:45
 */
public class RegesterCheckMapperImpl implements RegesterCheckMapper {
    private final DbutilsMapperImpl dbutilsMapperImpl = new DbutilsMapperImpl();
    @Override
    public boolean checkName(String username){
        //用户名验证可输入中文、字母及数字，限制4-12位
        String regExp = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{4,12}$";
        if (username.matches(regExp)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPassword(String password){
        String regExp = "^[a-zA-Z0-9]{6,12}";
        if (password.matches(regExp)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPhone(String phone) {
        String regExp = "^[1][0-9]{10,12}";
        if (phone.matches(regExp)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmail(String email){
        String regExp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        if (email.matches(regExp)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasExists(String username){
        List<String> names = dbutilsMapperImpl.getUsername();
        return names.contains(username);
    }
}
