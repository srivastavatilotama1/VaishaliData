package stu;

import bat.Batch;

public class Student 
{
	private int rollNo;
	private String stuName;
	private int  totalMarks;	
	private Batch stuBatchInfo;
	
	public Student(){}

	public int getRollNo() 
	{
		return rollNo;
	}
	
	public Batch getStuBatchInfo() {
		return stuBatchInfo;
	}

	public void setStuBatchInfo(Batch stuBatchInfo) {
		this.stuBatchInfo = stuBatchInfo;
	}

	public void setRollNo(int rollNo)
	{
		this.rollNo = rollNo;
	}

	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) 
	{
		this.stuName = stuName;
	}
	public int getTotalMarks() 
	{
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks)
	{
		this.totalMarks = totalMarks;
	}
	
	

}
