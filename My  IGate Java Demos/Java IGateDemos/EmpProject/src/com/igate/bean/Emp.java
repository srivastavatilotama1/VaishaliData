package com.igate.bean;

import java.io.Serializable;
import java.sql.Date;


public class Emp  implements Serializable,Comparable<Emp>
{
	int eid;
	String empname;
	float sal;
	char gen;
	Date dob;
	
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Emp(int eid, String empname, float sal, char gen,Date dob) {
		super();
		this.eid = eid;
		this.empname = empname;
		this.sal = sal;
		this.gen = gen;
		this.dob=dob;
	}
	/*@Override
	public String toString() {
		return "Emp [eid=" + eid + ", empname=" + empname + ", sal=" + sal
				+ ", gen=" + gen + " DOB: "+
				new java.sql.Date(((dob.getTime()).getTime()))+"]";
	}*/
	
	public String toString() {
		return "Emp [eid=" + eid + ", empname=" + empname + ", sal=" + sal
				+ ", gen=" + gen + " DOB: "+dob+"]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen = gen;
	}
	@Override
	public int hashCode() {
		
		return eid;
	}
	@Override
	public boolean equals(Object obj) 
	{
	Emp ee=(Emp)obj;
	
	if(this.eid==ee.eid)
	{
		return true;
	}
		return false;
	}
	@Override
	public int compareTo(Emp obj)	
	{
		if(this.eid<obj.eid)
		{
			return -1;
		}
		else if(this.eid==obj.eid)
		{
			return 0;
		}
		else
			return +1;
	}
	

}
