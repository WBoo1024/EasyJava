package com.lanou.student.util;



import java.util.Random;

public class CaptchaCode {
	private static final String[] co = {"a","b","c","e","f","g","h","i","j","k","l","m","n","o",
			"p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6",
			"7","8","9"};
	
	public static String getCode() {
		String s = "";
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			s += co[r.nextInt(35)];
		}
		System.out.println("验证码" + s);
		return s;
	}
}
