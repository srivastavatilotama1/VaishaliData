package com.igate.jaxb.unmarshal;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="depts")
public class Depts
{
	 public Depts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Depts [deptList=" + deptList + "]";
	}

	@XmlElement(name="dept",required=true)
	private List<Department> deptList;
	
	public List<Department> getDeptList() 
	{
		return deptList;
	}

	public void setDeptList(List<Department> deptList) 
	{
		this.deptList = deptList;
	}
	
}
