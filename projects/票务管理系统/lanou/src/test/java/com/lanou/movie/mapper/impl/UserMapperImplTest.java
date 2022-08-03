package com.lanou.movie.mapper.impl;

import com.lanou.movie.mapper.UserMapper;
import org.junit.Test;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 14:00
 */
public class UserMapperImplTest {
    @Test
    public void testMatchUser(){
        UserMapperImpl umi = new UserMapperImpl();
        System.out.println(umi.matchUser("小", "200184581865058357995277194937116494428"));
    }
}
