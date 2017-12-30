package com.igate.jaxb;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="empNameType",propOrder={"fname","mname","lname"})

public class EmpNameType
{
	@Override
	public String toString() {
		return "EmpNameType [fname=" + fname + ", lname=" + lname + ", mname="
				+ mname + "]";
	}
	@XmlElement(name="fn",required=true)
	String fname;
	
	@XmlElement(name="ln",required=true)
	String lname;
	
	@XmlElement(name="mn",required=true)
	String mname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	

}
