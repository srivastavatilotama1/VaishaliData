package com.cg.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login 
{
	
	
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}
	private String userName;
	private String password;
	
	
	@NotEmpty(message="User name Mandatory")
	@Size(min=5,message="UserName Should Have Min 5 Character")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@NotEmpty(message="Password Is Mandatory")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
