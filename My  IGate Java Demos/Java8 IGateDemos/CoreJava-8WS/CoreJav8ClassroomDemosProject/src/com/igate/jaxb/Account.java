package com.igate.jaxb;
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement
public class Account 
{   
	private String accNo; 	
	
	@XmlAttribute 
	private String accountType; 	
	
	public String name; 	
	
	@XmlAttribute   
	public String getAno() 
	{    
		return accNo; 
	}    
	public void setAno(String accNo)
	{      
		this.accNo = accNo;   
	}	
	
	public String getAccType() 
	{  
		return accountType;   
	}    
	public void setAccType(String accountType)
	{      
		this.accountType = accountType;   
	}  
	
}