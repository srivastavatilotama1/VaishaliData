package com.igate.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Employee
{

	private int eid;

	public Employee(int eid, String enm, double esl) {
		super();
		this.eid = eid;
		this.enm = enm;
		this.esl = esl;
	}

	private String enm;

	private double esl;

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
		+ "]";
	}



}
