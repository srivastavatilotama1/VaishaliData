package com.igate.dto;

public class Student  {
	
	 private int rollNo;
	 private String stuName;
	 private float marks;
	 private String  grade;
	 
	 public  Student()
	 {		 
		 System.out.println(" Student Constructor Invoked....");
	 }

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

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public String getGrade() {
		if(marks<40){
		
			grade="FAIL";
		}
		else
		{
			grade="PASS";
		}
		
		return grade;
	}

	

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", stuName=" + stuName
				+ ", marks=" + marks + ", grade=" + grade + "]";
	}
	 

}
