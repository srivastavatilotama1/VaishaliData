package com.igate.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="empType",propOrder={"id","empNameType","sal","gen"})
public class Employee   
{
	@Override
	public String toString() {
		return "\n\nEmployee [count=" + count + ", id=" + id + ", empNameType="
				+ empNameType + ", sal=" + sal + ", gen=" + gen + "]";
	}
	@XmlTransient int count;
	@XmlAttribute( name="empId",required=true)
	private int id;
	
	@XmlElement(name="empName", required=true)
	private	 EmpNameType  empNameType;
	
	@XmlElement(name="empSal", required=true)
	private 	float sal;
	
	@XmlElement(name="empGender", required=true)
	private	char gen;
	
		public EmpNameType getEmpNameType() 
	{
		return empNameType;
	}
	public void setEmpNameType(EmpNameType empNameType) 
	{
		this.empNameType = empNameType;
	}	
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public float getSal() 
	{
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen = gen;
	}
	
	


}
