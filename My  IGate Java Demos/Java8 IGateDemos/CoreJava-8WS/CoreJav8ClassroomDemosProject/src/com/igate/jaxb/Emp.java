package com.igate.jaxb;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Emp {

	private String eno; 		
	public String ename; 	
	
	@XmlAttribute   
	public String getEmpNo() 
	{    
		return eno; 
	}    
	public void setEmpNo(String eno)
	{      
		this.eno = eno;   
	}	
}
