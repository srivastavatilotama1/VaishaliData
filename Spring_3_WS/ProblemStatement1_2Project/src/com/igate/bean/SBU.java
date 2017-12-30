package com.igate.bean;

public class SBU
{
	String sbuId;
	String sbuName;
	String sbuHead;
	
	public String getSbuId() {
		return sbuId;
	}
	public void setSbuId(String sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName()
	{
		return sbuName;
	}
	public void setSbuName(String sbuName)
	{
		this.sbuName = sbuName;
	}
	public String getSbuHead() 
	{
		return sbuHead;
	}
	public void setSbuHead(String sbuHead)
	{
		this.sbuHead = sbuHead;
	}
	@Override
	public String toString() 
	{
		return "SBU [sbuId=" + sbuId + ", sbuName=" + sbuName + ", sbuHead="
				+ sbuHead + "]";
	}
	
	

}
