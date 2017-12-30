package com.igate.jaxb;
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlRootElement;   
@XmlRootElement
public class Root
{     
	private String fieldA; 
	
	@XmlAttribute 
	private String fieldB; 
	
	public String fieldC;  
	
	@XmlAttribute   
	public String getPropertyA() 
	{      
		return fieldA; 
	}    
	public void setPropertyA(String a)
	{      
		this.fieldA = a;   
	}
	
	
	public String getPropertyB() 
	{  
		return fieldB;   
	}    
	public void setPropertyB(String b)
	{      
		this.fieldB = b;   
	}  
} 


