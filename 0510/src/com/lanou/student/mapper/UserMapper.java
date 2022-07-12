package com.lanou.student.mapper;

import java.util.Arrays;

import java.util.Objects;

import com.lanou.student.bean.User;
import com.lanou.student.util.PasswordUtil;


public class UserMapper {
	private User[] users;
	private int index;

	public UserMapper() {
		users = new User[1];
		users[index++] = new User("qwertyu",PasswordUtil.md5("qwertyu","qwertyu"),"1234@qq.com","15071520738");
	}

	public boolean regester(User user) {
		try {
			grow();// 扩容
			users[index++] = user;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void grow() {
		// 扩容之前需要获取到原来的容量
		int oldCapacity = users.length;
		if (index == 0) {
			users = new User[1];
		}
		// 需要扩容
		else if (index == oldCapacity) {
			// 获取一个新容量
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			if (newCapacity == 1) {
				newCapacity = 2;
			}
			// 把原来数组里面的元素存放到新数组里面
			users = Arrays.copyOf(users, newCapacity);
		}
	}

	/**
	 * 获取有多少个用户
	 */
	public int size() {
		return index;
	}

	public User getUser(String userName, String email) {
		try {
			for (int i = 0; i < index; i++) {
				User u = users[i];
				if (null == userName) {
					if (Objects.equals(email, u.getEamil())) {
						return u;
					}
				}
				if (null == email) {
					if (Objects.equals(userName, u.getUserName())) {
						return u;
					}
				}
				if (Objects.equals(userName, u.getUserName()) && Objects.equals(email, u.getEamil())) {
					return u;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
		
	}

	public boolean logout(String next) {
		int i = getName(next);
		if (i == -1) {
			return false;
		} else {
			for (int j = i + 1; j < index; j++) {
				users[j - 1] = users[j];
			}
		}
		index--;
		System.out.println("现在用户名有" + index + "个");
		return true;
	}

	private int getName(String next) {
		System.out.println("当前用户名有" + index + "个");
		for (int i = 0; i < index; i++) {
			if ((users[i]).getUserName().equals(next)) {
				return i;
			}
		}
		return -1;
	}

}
