package com.cg.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component("urObj")
@PropertySource("classpath:user.properties")

public class User
{
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", userLocs=" + userLocs + "]";
	}
	@Value("${unm}")
	private String userName;
	
	@Value("${pwd}")
	private String password;
	
	private ArrayList<String> userLocs;
	public ArrayList getUserLocs() {
		return userLocs;
	}
	public void setUserLocs(ArrayList userLocs) {
		this.userLocs = userLocs;
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
}
