package com.igate.jdbc;

import org.springframework.beans.factory.annotation.Value;

public class Date 
{
	int dd;
	int yy;
	int mm;
	public int getDd() 
	{
		return dd;
	}
	@Value("12")
	public void setDd(int dd) 
	{
		this.dd = dd;
	}
	public int getYy()
	{
		return yy;
	}
	@Value("1980")
	public void setYy(int yy)
	{
		this.yy = yy;
	}
	public int getMm() {
		return mm;
	}
	@Value("1")
	public void setMm(int mm) 
	{
		this.mm = mm;
	}
	@Override
	public String toString() {
		return "Date [dd=" + dd + ", yy=" + yy + ", mm=" + mm + "]";
	}

}
