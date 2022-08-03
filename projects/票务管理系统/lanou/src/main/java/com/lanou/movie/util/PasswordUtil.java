package com.lanou.movie.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: lanou
 * @description: 加密密码
 * @author: 壹零二四
 * @created: 2022/07/12 11:10
 */
public class PasswordUtil {
    public static String md5(String username,String password){
        byte[] bys = {};
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
            bys = md.digest((username+password).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1,bys).toString();
    }
}
