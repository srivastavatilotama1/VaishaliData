package com.igate.jdbc.bean;

public class Employee {
	
	private int eid;
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
		return "Employee [eid=" + eid + ", enm=" + enm + ", esl=" + esl + "]";
	}
	
	
	

}
