package com.lanou.student.bean;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String eamil;
	private String phone;
	private String creatTime;
	private boolean isRoot;
	
	
	public User() {
		
	}
	
	
	public User(String userName, String passWord, String eamil, String phone) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.eamil = eamil;
		this.phone = phone;
	}


	public User(String userName, String passWord, String eamil, String phone, String creatTime, boolean isRoot) {	
		this.userName = userName;
		this.passWord = passWord;
		this.eamil = eamil;
		this.phone = phone;
		this.creatTime = creatTime;
		this.isRoot = isRoot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	
	
	
	
}
