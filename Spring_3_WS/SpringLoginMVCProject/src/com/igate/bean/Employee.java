package com.igate.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.validator.NotNull;




public class Employee  implements Serializable
{

	private int eid;

	
	@NotNull(message="mandatory field")
	//@Pattern(regexp="^[a-zA-Z]+$",message="Enter Valid Name ")
	//@Size(min=3, max=30) 
	private String firstName;


	//@Pattern(regexp="^[a-zA-Z ]+$",message="Enter Valid Name ")	
	//@NotNull
	private String lastName;

	private String city;
	private String[] prefLanguages;
	private String maritalStaus;

	//@NotNull
	//@Email
	private String emailAddress;
	
	//@NotEmpty
	private long mobileNo;

	//@NotEmpty
	//@Range(min=10000,message="Minimum Salary Should be 10000")
	private int salary;

	//@NotNull
	//@Past(message="Joining  Date must be past Date")
	//@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date joinedDate;

	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	private double annualPackage;



	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
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
		return "Employee [eid=" + eid + ", firstName=" + firstName
		+ ", lastName=" + lastName + ", city=" + city
		+ ", prefLanguages=" + Arrays.toString(prefLanguages)
		+ ", maritalStaus=" + maritalStaus + ", salary=" + salary
		+ ", joinedDate=" + joinedDate + ", annualPackage="
		+ annualPackage + "]";
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String firstName, String lastName, String city,
			String[] prefLanguages, String maritalStaus, int salary,
			Date joinedDate, double annualPackage) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.prefLanguages = prefLanguages;
		this.maritalStaus = maritalStaus;
		this.salary = salary;
		this.joinedDate = joinedDate;
		this.annualPackage = annualPackage;
	}


}
