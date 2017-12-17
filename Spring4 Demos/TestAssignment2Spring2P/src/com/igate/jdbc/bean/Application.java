package com.igate.jdbc.bean;


import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Application 
{
	public Application()
	{		super();	}
	int applicationId ;
	String condition;
	
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Pattern(regexp="^[a-zA-Z]+$",message="Enter Only Characters  ")	
	@NotEmpty(message="User Name is mandatory")
	String username ;
	
	@Email(message="Please enter valid Email ID")
	@NotEmpty(message="Email Id is mandatory")
	String emailId ;
	
	@NotEmpty(message="Mobile is mandatory")
	@Pattern(regexp="[0-9]{8,}",message="Minimum 8 digits should be ther e in mobile no.  ")	
	String mobileNumber ;
	
	String city;
	
	@Pattern(regexp="\\d{2}-\\d{2}-\\d{4}",message="Enter  Date in dd-mm-yyyy format  ")	
	String applicationDateText;	
	LocalDate appliedDate ;
		
	public String getApplicationDateText() {
		return applicationDateText;
	}
	public void setApplicationDateText(String applicationDateText) {
		this.applicationDateText = applicationDateText;
	}
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
	
	
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		System.out.println(appliedDate+"................................");
		this.appliedDate = appliedDate;
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
