package com.igate.dto;

import java.util.Date;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.NotNull;
import org.hibernate.validator.Past;
import org.hibernate.validator.constraints.Range;

public class Student
{
	@Pattern(regexp="^[a-zA-Z ]+$",message="Enter Valid Name ")
	@NotNull
	private String name;
	@Range(min=1,max=10,message="Enter Roll No Between 1-10")
	private int roll;
	
	@Past(message="Enroll Date must be past Date")
	private Date enrollDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Student(String name, int roll, Date enrollDate) {
		super();
		this.name = name;
		this.roll = roll;
		this.enrollDate = enrollDate;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

}
