package com.cg.dto;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterDto 
{
	private	String uname;
	private String pwd;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;
	private String[] skillSet;
	private String city;
	private char gender;	
	private LocalDate dobLocalDate;
	private String skillSetStr;
	
	public void setSkillSetStr(String skillSetStr) {
		this.skillSetStr = skillSetStr;
	}

	public String getSkillSetStr() 
	{
		return skillSetStr;
	}
	
	public LocalDate getDobLocalDate() {
		return dobLocalDate;
	}
	public void setDobLocalDate(LocalDate dobLocalDate) {
		this.dobLocalDate = dobLocalDate;
	}
	@Pattern(regexp="\\d{2}-\\d{2}-\\d{4}",message="Enter  Date in dd-mm-yyyy format  ")	
	String dobDateText;	
	
	public String getDobDateText() {
		return dobDateText;
	}
	public void setDobDateText(String dobDateText) {
		this.dobDateText = dobDateText;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@NotEmpty(message="Mandatory User name")
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@NotEmpty(message="Mandatory Passwod")
	@Pattern(regexp="[a-zA-Z0-9]{5,}",
	message="Minimum 5 char and only small cplital letteres and digts are allowed.")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@NotEmpty(message="Manadatory Field")
	@Email(message=" Plaese enter valid email address")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "RegisterDto [uname=" + uname + ", pwd=" + pwd
				+ ", confirmPassword=" + confirmPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", skillSet=" + Arrays.toString(skillSet) + ", city=" + city
				+ ", gender=" + gender + ", dobDateText=" + dobDateText + "]";
	}
	

}
