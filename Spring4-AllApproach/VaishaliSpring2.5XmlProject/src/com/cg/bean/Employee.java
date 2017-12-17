package com.cg.bean;

import java.sql.Date;



public class Employee 
{
	private int eid;
	private String enm;
	private int eage;
	private Address empAddress;
	Date doj;
	java.util.Date dob;	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public Address getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}
	private double esl;
	
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", enm=" + enm + ", eage=" + eage
				+ ", empAddress=" + empAddress + ", doj=" + doj + ", dob="
				+ dob + ", esl=" + esl + "]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEnm() {
		return enm;
	}
	public void setEnm(String enm) {
		this.enm = enm;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}

	public double getEsl() {
		return esl;
	}
	public void setEsl(double esl) {
		this.esl = esl;
	}

}
