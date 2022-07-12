package com.lanou.student.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static String md5(String password,String userName) {
		byte[] bys = {};
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			bys = md.digest((password + userName).getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new BigInteger(1,bys).toString(16);
	}
}
