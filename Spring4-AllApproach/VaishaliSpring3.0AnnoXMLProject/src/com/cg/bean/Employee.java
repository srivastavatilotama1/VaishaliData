package com.cg.bean;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("empObj")
public class Employee 
{
	@Value("#{T(java.lang.Math).random()*100}")
	private int eid;
	
	@Value("#{per.firstName}")
	private String enm;
	
	@Value("#{per.getAge()}")
	private int eage;
	
	@Autowired
	@Qualifier("offAdd")
	private Address empAddress;
	
	@Value("getDoj()")
	Date doj;
	
	@Value("03-02-2013")
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
	
	@Value("100000")
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
