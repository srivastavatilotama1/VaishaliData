package com.igate.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Employee
{
	
	private int eid;
	
	@Value("Vaishali")
	private String enm;
	
	private double esl;
	
	@Autowired
	Date dob;
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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
	public double getEsl() {
		return esl;
	}
	
	public void setEsl(double esl) {
		this.esl = esl;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", enm=" + enm + ", esl=" + esl
				+ ", dob=" + dob + "]";
	}
	
	

}
