package com.igate.bean;

import java.util.ArrayList;

public class SBU
{
private	String sbuId;
private String sbuName;
private 	String sbuHead;
private ArrayList<Employee> empList;
	
	public String getSbuId() {
		return sbuId;
	}
	public ArrayList<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}
	public void setSbuId(String sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName()
	{
		return sbuName;
	}
	public void setSbuName(String sbuName)
	{
		this.sbuName = sbuName;
	}
	public String getSbuHead() 
	{
		return sbuHead;
	}
	public void setSbuHead(String sbuHead)
	{
		this.sbuHead = sbuHead;
	}
	@Override
	public String toString() {
		return "SBU [sbuId=" + sbuId + ", sbuName=" + sbuName + ", sbuHead="
				+ sbuHead + ", empList=" + empList + "]";
	}
	
}
