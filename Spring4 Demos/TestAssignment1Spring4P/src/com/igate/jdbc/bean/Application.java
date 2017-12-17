package com.igate.jdbc.bean;

import java.time.LocalDate;

public class Application 
{
	public Application()
	{		super();	}
	int applicationId ;
	String username ;
	String emailId ;
	String mobileNumber ;
	String city;
	LocalDate appliedDate ;
	String accountExists ;
	public int getApplicationId() 
	{
		return applicationId;
	}
	public void setApplicationId(int applicationId) 
	{
		this.applicationId = applicationId;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAccountExists() {
		return accountExists;
	}
	public void setAccountExists(String accountExists) {
		this.accountExists = accountExists;
	}
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", username="
				+ username + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", city=" + city
				+ ", appliedDate=" + appliedDate + ", accountExists="
				+ accountExists + "]";
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public Application(int applicationId, String username, String emailId,
			String mobileNumber, String city, LocalDate appliedDate,
			String accountExists) {
		super();
		this.applicationId = applicationId;
		this.username = username;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.appliedDate = appliedDate;
		this.accountExists = accountExists;
	}
	
	

}
