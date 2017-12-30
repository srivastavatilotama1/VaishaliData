package com.igate.dto;

public class UserDto 
{
	private String name;
	private String username;
	private String password;
	private String mobilenumber;
	private double billamount;
	
	
	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public double getBillamount() {
		return billamount;
	}

	public void setBillamount(double billamount) {
		this.billamount = billamount;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", username=" + username
				+ ", password=" + password + ", mobilenumber=" + mobilenumber
				+ ", billamount=" + billamount + "]";
	}


}
