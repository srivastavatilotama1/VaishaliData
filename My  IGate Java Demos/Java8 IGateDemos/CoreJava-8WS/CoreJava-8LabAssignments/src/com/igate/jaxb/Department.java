package com.igate.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name="Department",propOrder={"departmentId","departmentName","managerId"})
public class Department
{

	@Override
	public String toString()
	{
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", managerId=" + managerId + "]";
	}
	@XmlElement(name="departmentId",required=true)
	private int departmentId;
	
	@XmlElement(name="departmentName",required=true)
	private String departmentName;
	
	@XmlElement(name="managerId",required=true)
	private int managerId;

	public Department(int departmentId, String departmentName, int managerId) {
	
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	
}
