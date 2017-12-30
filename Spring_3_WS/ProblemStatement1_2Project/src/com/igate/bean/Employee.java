package com.igate.bean;

public class Employee 
{
	int employeeId;
	String employeeName;
	double salary;
	SBU businessUnit;
	int age;
	public int getEmployeeId()
	{
		return employeeId;
	}
	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void dispEmp()
	{
		System.out.println("Employee Details");
		System.out.println("-----------------------------");
		System.out.println("Employee ID : "+employeeId);
		System.out.println("Employee Name : "+employeeName);
		System.out.println("Employee Salary : "+businessUnit);
		System.out.println("Employee Business Unit  :"+businessUnit);
		System.out.println("Employee Age  :"+age);
		
	}
	@Override
	public String toString() 
	{
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", salary=" + salary +
				", age=" + age + " \n businessUnit:  "+ businessUnit + 
				"]";
	}
	public SBU getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(SBU businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	
	
}