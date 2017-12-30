package com.igate.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.validator.constraints.Range;

public class Employee  implements Serializable
{
	@Range(min=1,max=300,message="Enter Valid Roll No ")
	private int employeeId;
	private String firstName;
	private String lastName;
	private String city;
	private String[] prefLanguages;
	private String maritalStaus;
	private double salary;
	private Date joinedDate;
	private double annualPackage;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String[] getPrefLanguages() {
		return prefLanguages;
	}
	public void setPrefLanguages(String[] prefLanguages) {
		this.prefLanguages = prefLanguages;
	}
	public String getMaritalStaus() {
		return maritalStaus;
	}
	public void setMaritalStaus(String maritalStaus) {
		this.maritalStaus = maritalStaus;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public double getAnnualPackage() {
		return annualPackage;
	}
	public void setAnnualPackage(double annualPackage) {
		this.annualPackage = annualPackage;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", city=" + city
				+ ", prefLanguages=" + Arrays.toString(prefLanguages)
				+ ", maritalStaus=" + maritalStaus + ", salary=" + salary
				+ ", joinedDate=" + joinedDate + ", annualPackage="
				+ annualPackage + "]";
	}
	public Employee(int employeeId, String firstName, String lastName,
			String city, String[] prefLanguages, String maritalStaus,
			double salary, Date joinedDate, double annualPackage) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.prefLanguages = prefLanguages;
		this.maritalStaus = maritalStaus;
		this.salary = salary;
		this.joinedDate = joinedDate;
		this.annualPackage = annualPackage;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

}
