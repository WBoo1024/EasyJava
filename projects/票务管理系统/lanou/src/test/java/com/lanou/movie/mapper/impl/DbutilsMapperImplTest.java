package com.lanou.movie.mapper.impl;

import com.lanou.movie.bean.User;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 10:06
 */
public class DbutilsMapperImplTest {
    private DbutilsMapperImpl dmi;
    private User user;
    @Before
    public void setUp() {
        dmi = new DbutilsMapperImpl();
        user = new User("小王","123456789","2022-07-12","15071520738","1533690878@qq.com");
    }
    @Test
    public void testAdd(){
        System.out.println(dmi.add(user));
    }
}
