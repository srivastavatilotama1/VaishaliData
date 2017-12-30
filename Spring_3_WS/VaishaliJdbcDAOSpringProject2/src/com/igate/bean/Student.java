package com.igate.bean;
public class Student
{
	String name;
	int roll;
	double fees;
	
	public Student(int roll,String name,  double fees)
	{
		super();
		this.name = name;
		this.roll = roll;
		this.fees = fees;
	}
	public Student() {
		
	}
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
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", fees=" + fees
				+ "]";
	}
	
}