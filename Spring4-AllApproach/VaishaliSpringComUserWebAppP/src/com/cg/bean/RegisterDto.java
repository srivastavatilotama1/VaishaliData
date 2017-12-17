package com.cg.bean;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cg_userDetails")
public class RegisterDto 
{
	@Id
	@Column(name="user_name")
	@NotEmpty(message="Mandatory User name")
	@Pattern(regexp="[A-Za-z]{1,15}",
	message="Only Charactes allowed and  Start with Caplital")
	private  String uname;
	
	
	
	@Override
	public String toString() {
		return "RegisterDto [uname=" + uname + ", pwd=" + pwd
				+ ", confirmPassword=" + confirmPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", skillSet=" + Arrays.toString(skillSet) + ", gender="
				+ gender + ", city=" + city + ", skillSetStr=" + skillSetStr
				+ ", dobUtilDate=" + dobUtilDate + ", dobDateText="
				+ dobDateText + "]";
	}
	@Transient	
	private String pwd;
	

	@Transient
	private String confirmPassword;
	
	@Column(name="first_name")
	private String firstName;
		
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="user_email")
	private String email;
	
	@Transient
	private String skillSet[];
	
	@Column(name="user_gender")
	private  char gender;
	
	@Column(name="user_city")
	private String city;
	
	@Column(name="user_skill")
	private String  skillSetStr;
	

	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private   Date dobUtilDate;
	
	
	
	public Date getDobUtilDate() {
		return dobUtilDate;
	}
	public void setDobUtilDate(Date dobUtilDate) {
		this.dobUtilDate = dobUtilDate;
	}
	public String getDobDateText() {
		return dobDateText;
	}
	public void setDobDateText(String dobDateText) {
		this.dobDateText = dobDateText;
	}
	@Transient
	@Pattern(regexp="\\d{2}-\\d{2}-\\d{4}",
			message="Enter  Date in dd-mm-yyyy format  ")	
	String dobDateText;	
	
	
	
	public String getUname() {
		return uname;
	}
	public RegisterDto(String uname) {
		super();
		this.uname = uname;
	}
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSkillSetStr() {
		return skillSetStr;
	}
	public void setSkillSetStr(String skillSetStr) {
		this.skillSetStr = skillSetStr;
	}

}
