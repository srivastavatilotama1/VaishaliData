package com.igate.eis.bean;

public class Employee implements Comparable<Employee>
{
	private int empId;
	private String empName;
	private float empSal;
	private String insuranceScheme;

	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	public Employee(int empId, String empName, float empSal )
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		if(empSal<5000)
		{
			this.insuranceScheme="Clerk";
		}
		else if((empSal>=5000)&&(empSal<20000))
		{
			this.insuranceScheme="Scheme C";
		}
		else if((empSal>=20000)&&(empSal<40000))
		{
			this.insuranceScheme="Scheme B";			
		}
		else 
		{
			this.insuranceScheme="Scheme A";			
		}

	}
	public Employee() {
		super();		
	}
	@Override
	public String toString() 
	{
		return "\t\tEmployee [empId=" + empId + ", empName=" + empName
		+ ", empSal=" + empSal + ", insuranceScheme=" + insuranceScheme
		+ "]";
	}

	@Override
	public int compareTo(Employee obj) 
	{
		//Sort emp by salary
		if(obj.getEmpSal()<this.getEmpSal())
		{
			return -1;
		}
		else if(obj.getEmpSal()>this.getEmpSal())
		{
			return +1;		
		}
		else
		{
			return 0;
		}
	}



}
