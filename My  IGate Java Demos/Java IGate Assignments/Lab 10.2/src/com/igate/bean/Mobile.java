/**
 * @author vivek
 * 
 */

package com.igate.bean;

import com.igate.annotation.Author;

public class Mobile 
{
	@Author(AuthorName ="Vivek Pansara", date="02-02-1993", description = "Mobile Class", version = "1.0")
	private int mobileId;
	private String mobileName;
	private double mobilePrice;
	private int mobileQuantity;
	
	public Mobile(int mobileId, String mobileName, double mobilePrice, int mobileQuantity) 
	{
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
		this.mobileQuantity = mobileQuantity;
	}
	
	public Mobile() 
	{}
	
	public String getMobileName() 
	{
		return mobileName;
	}
	
	public void setMobileName(String mobileName) 
	{
		this.mobileName = mobileName;
	}
	
	public double getMobilePrice() 
	{
		return mobilePrice;
	}
	
	public void setMobilePrice(double mobilePrice) 
	{
		this.mobilePrice = mobilePrice;
	}
	
	public int getMobileQuantity() 
	{
		return mobileQuantity;
	}
	
	public void setMobileQuantity(int mobileQuantity) 
	{
		this.mobileQuantity = mobileQuantity;
	}
	
	public int getMobileId() 
	{
		return mobileId;
	}
}