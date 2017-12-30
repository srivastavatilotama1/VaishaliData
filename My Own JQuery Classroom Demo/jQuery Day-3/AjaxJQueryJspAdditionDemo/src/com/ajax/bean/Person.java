package com.ajax.bean;

public class Person {
	
	private int empId;
	private String firstName;
	private String lastName;
	private String location;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String toString() {
		return empId+" " + firstName + " " + lastName
				+ " " + location ;
	}
	public Person(int empId, String firstName, String lastName, String location) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	public Person() {
	}
	
	
	

}
