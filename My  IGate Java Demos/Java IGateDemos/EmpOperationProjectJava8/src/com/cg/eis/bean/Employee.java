package com.cg.eis.bean;
import java.time.LocalDate;
import java.time.Period;
public class Employee 
{
	private int empId;
	private String empName;
	private float empSal;
	private LocalDate dateOfJoin;
	private  String experience;
	public String getExperience(LocalDate doj) 
	{
		LocalDate  today=LocalDate.now();
		Period period=Period.between(doj, today);
		int year=period.getYears();
		int months=period.getMonths();
		int days=period.getDays();
		experience=year +" Year:"+months+" Months:"+days+" Days:";
		return experience;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public Employee(int empId, String empName, float empSal,
			LocalDate dateOfJoin) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.dateOfJoin = dateOfJoin;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSal=" + empSal + ", dateOfJoin=" + dateOfJoin + "]";
	}
	public Employee() {
		super();		
	}
}
