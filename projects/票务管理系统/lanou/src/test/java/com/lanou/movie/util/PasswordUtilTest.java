package com.lanou.movie.util;

import org.junit.Test;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 11:37
 */
public class PasswordUtilTest {
    @Test
    public void testMd5(){
        System.out.println(PasswordUtil.md5("小王","123456"));
    }
}
