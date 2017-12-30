package com.igate.trainee.beans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Login {
	
	@NotEmpty(message="Please Enter Username")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	private String username;
	
	@NotEmpty(message="Please Enter Password")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Password must contain only alphabets")
	private String password;
	
	
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
	
	
}
