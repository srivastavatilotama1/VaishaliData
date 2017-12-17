package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cg_users")
public class Login
{

	@Id
	@Column(name="user_name")	
	private String userName;
	
	@Column(name="password")
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
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}
	
}
