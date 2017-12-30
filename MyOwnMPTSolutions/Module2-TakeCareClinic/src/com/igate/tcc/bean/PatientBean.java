package com.igate.tcc.bean;

public class PatientBean 
{
	String patientId;
	String patientName;
	String age;
	String phoneNum;
	String description;
	String consultationDate;
	
	public PatientBean()
	{
		
	}
	public String getPatientId() 
	{
		return patientId;
	}
	public void setPatientId(String patientId) 
	{
		this.patientId = patientId;
	}
	public String getPatientName() 
	{
		return patientName;
	}
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getPhoneNum()
	{
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getConsultationDate()
	{
		return consultationDate;
	}
	public void setConsultationDate(String consultationDate)
	{
		this.consultationDate = consultationDate;
	}
	public PatientBean(String patientName, String age, String phoneNum,
			String description) 
	{
		super();
		this.patientName = patientName;
		this.age = age;
		this.phoneNum = phoneNum;
		this.description = description;
	}
	
}
