/**
 * @author vivek
 * 
 */

package com.igate.bean;

import java.util.Date;

import com.igate.annotation.Author;

public class Customer 
{
	@Author(AuthorName ="Vivek Pansara", date="02-02-1993", description = "Customer Class", version = "1.0")
	private String custName;
	private String mailId;
	private long mobileNo;
	private Mobile mobile;
	private int purchaseId;
	private Date purchaseDate;
	private static int  COUNTER ;
	
	static 
	{
		COUNTER = 101;
	}
	
	public Customer() 
	{
		super();
	}
	
	public Customer(String custName, String mailId, long mobileNo, int purchaseId, Date purchaseDate,int mobileId,String mobileName,double mobilePrice,int mobileQuantity) 
	{
		this.custName = custName;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
		this.purchaseId = COUNTER++;
		this.purchaseDate = purchaseDate;
		mobile = new Mobile(mobileId, mobileName, mobilePrice, mobileQuantity);
	}
	
	public String getCustName() 
	{
		return custName;
	}
	
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	
	public String getMailId() 
	{
		return mailId;
	}
	
	public void setMailId(String mailId) 
	{
		this.mailId = mailId;
	}
	
	public long getMobileNo() 
	{
		return mobileNo;
	}
	
	public void setMobileNo(long mobileNo) 
	{
		this.mobileNo = mobileNo;
	}
	
	public Mobile getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(Mobile mobile) 
	{
		this.mobile = mobile;
	}
	
	public Date getPurchaseDate() 
	{
		return purchaseDate;
	}
	
	public void setPurchaseDate(Date purchaseDate) 
	{
		this.purchaseDate = purchaseDate;
	}
	
	public int getPurchaseId() 
	{
		return purchaseId;
	}
}