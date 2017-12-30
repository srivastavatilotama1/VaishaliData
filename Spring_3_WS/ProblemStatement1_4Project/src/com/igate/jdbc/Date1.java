package com.igate.jdbc;

import org.springframework.beans.factory.annotation.Value;

public class Date1 {
	int dd;
	int yy;
	int mm;
	public int getDd() 
	{
		return dd;
	}
	public void setDd(int dd) 
	{
		this.dd = dd;
	}
	public int getYy()
	{
		return yy;
	}

	public void setYy(int yy)
	{
		this.yy = yy;
	}
	public int getMm() {
		return mm;
	}

	public void setMm(int mm) 
	{
		this.mm = mm;
	}
	@Override
	public String toString() {
		return "Date1 [dd=" + dd + ", yy=" + yy + ", mm=" + mm + "]";
	}
}
