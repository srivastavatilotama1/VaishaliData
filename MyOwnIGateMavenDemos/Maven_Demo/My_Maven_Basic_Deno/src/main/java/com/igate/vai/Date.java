package com.igate.vai;
public class Date
{
	int day;
	int  mon;
	int year;
	static int  dateCount=0;
	
	public void initDate()
	{
		day=0;
		mon=0;
		year=0;
	}
	public void setDate(int dd,int mm,int yy)
	{
		day=dd;
		mon=mm;
		year=yy;
		
	}
	public String dispDate()
	{
		return ( day+"/"+mon+"/"+year);		
	}
	
	public Date(int day, int mon, int year)
	{
		this.day = day;
		this.mon = mon;
		this.year = year;
	}	
	public Date()
	{
		this.day = 0;
		this.mon = 0;
		this.year = 0;
	}
	
	
	
	
	
	

}
