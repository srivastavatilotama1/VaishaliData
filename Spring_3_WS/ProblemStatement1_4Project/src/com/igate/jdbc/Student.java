package com.igate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("s1")
public class Student {
	int rollno;
	String name;
	//@Autowired(required=false)
	@Autowired(required=true)
	@Qualifier("studob2")
	Date1 studob;
	public int getRollno() {
		return rollno;
	}
	@Value("888")
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	@Value("samir")
	public void setName(String name) {
		this.name = name;
	}
	public Date1 getStudob() {
		return studob;
	}
	public void setStudob(Date1 studob) {
		this.studob = studob;
	}
	public Student(int rollno, String name, Date1 studob) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.studob = studob;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", studob="
				+ studob + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
