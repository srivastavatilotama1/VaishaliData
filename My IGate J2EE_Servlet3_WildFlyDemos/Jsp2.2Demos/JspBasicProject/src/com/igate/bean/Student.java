package com.igate.bean;

public class Student 
{
	private int rollNo;
	private String stuName;
	private int marks;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student()
	{
		super();		
	}
	
	public String getGrade()
	{
		if(marks<40)
		{
			return " U R FAIL";
		}
		else if((marks>=40)&&(marks<60))
		{
			return " Second Class"; 
		}
		else if((marks>=60)&&(marks<75))
		{
			return " FIRST Class"; 
		}
		else
		{
			return " DISTINCTION"; 
		}	
	}
}
