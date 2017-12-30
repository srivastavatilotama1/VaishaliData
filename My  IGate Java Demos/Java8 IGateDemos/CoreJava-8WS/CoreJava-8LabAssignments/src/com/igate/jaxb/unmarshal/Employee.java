package com.igate.jaxb.unmarshal;


import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)

public class Employee {

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", designation=" + designation + ", salary=" + salary
				+ ", managerId=" + managerId + ", department=" + department
				+ "]";
	}
	
	@XmlAttribute( name="empId",required=true)
	private Integer employeeId;
	
	@XmlElement(name="firstName", required=true)
	private String firstName;
	
	@XmlElement(name="lastName")
	private String lastName;
	
	@XmlElement(name="email")
	private String email;
	
	@XmlElement(name="phoneNumber")
	private String phoneNumber;
	
	@XmlElement(name="hireDate")
	private LocalDate hireDate;
	
	@XmlElement(name="designation")
	private String designation;
	
	@XmlElement(name="salary")
	private double salary;
	
	
	@XmlElement(name="managerId")
	private Integer managerId;
	
	
	private Department department;
	
	
	public Employee(Integer employeeId, String firstName, String lastName,
			String email, String phoneNumber, LocalDate hireDate,
			String designation, double salary, Integer managerId,
			Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
		this.department = department;
	}
	
	public Employee() {
		super();
	}

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
