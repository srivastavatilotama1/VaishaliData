package com.igate.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("s1")
@Scope("prototype")
public class Student
{
	@Value("IGATE")
	private String name;
	
	@Value("444")
	int roll;

	public Student(int roll)
	{
		super();
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}

	public Student()
	{
		super();
		
	}

}
