package com.igate.bean;

import java.util.Date;

public class Student
{
	String name;
	int roll;
	Date enrollDate;

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Student(int roll)
	{
		super();
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	

	

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", enrollDate="
				+ enrollDate + "]";
	}

	public Student()
	{
		super();
		
	}

}
