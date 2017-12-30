package com.igate.rest.bean;

//@XmlRootElement
public class User {

	private int userid;

	private String userName;

	private String password;

	private String email;

	public User(int userid, String userName, String password, String email) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public User() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return userid + "  " + userName + "  " + password + "  " + email;
	}
}