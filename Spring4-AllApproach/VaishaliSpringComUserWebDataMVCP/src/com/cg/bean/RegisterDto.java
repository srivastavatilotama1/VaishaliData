package com.cg.bean;
import java.time.LocalDate;
import java.util.Arrays;

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
	private  String uname;		
	@Transient	
	private String pwd;
	
	@Transient
	private String confirmPassword;
	
	

	public RegisterDto(String uname, String firstName, String lastName,
			String email, String[] skillSet, char gender, String city) {
		super();
		this.uname = uname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.skillSet = skillSet;
		this.gender = gender;
		this.city = city;
	}
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
	
	public String getUname() {
		return uname;
	}
	public RegisterDto(String uname) {
		super();
		this.uname = uname;
	}
	public RegisterDto() {
		super();
		
	}
	@Override
	public String toString() {
		return "RegisterDto [uname=" + uname + ", pwd=" + pwd
				+ ", confirmPassword=" + confirmPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", skillSet=" + Arrays.toString(skillSet) + ", gender="
				+ gender + ", city=" + city + ", skillSetStr=" + skillSetStr
				+ "]";
	}
	public void setUname(String uname) {
		this.uname = uname;
	}	
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
