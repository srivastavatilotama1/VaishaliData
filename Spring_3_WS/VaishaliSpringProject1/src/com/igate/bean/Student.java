package com.igate.bean;

import java.util.List;

public class Student
{
	String name;
	int roll;
	Address homeAddress;
	private List<String> subjects;
	

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
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
		return "Student [name=" + name + ", roll=" + roll + ", homeAddress="
				+ homeAddress + ", subjects=" + subjects + "]";
	}

	public Student()
	{
		super();
		
	}

}
