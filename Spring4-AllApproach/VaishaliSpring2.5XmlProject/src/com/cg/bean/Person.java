package com.cg.bean;

import java.util.ArrayList;

public class Person 
{
	private String firstName;
	private String lastName;
	private int age;
	private 	ArrayList addList;
	public int getAge() {
		return age;
	}
	public ArrayList getAddList() {
		return addList;
	}
	public void setAddList(ArrayList addList) {
		this.addList = addList;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", addList=" + addList + "]";
	}
	public void setAge(int age) {
		this.age = age;
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


}
