package com.igate.tcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.igate.tcc.bean.PatientBean;
import com.igate.tcc.dao.IPatientDAO;
import com.igate.tcc.dao.PatientDAO;
import com.igate.tcc.exception.PatientException;

public class PatientService implements IPatientService
{

	//------------------------ 1. Take Care Clinic Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addPatientDetails
	 - Input Parameters	:	patient object
	 - Return Type		:	int
	 - Throws			:  	PatientException
	 - Author			:	IGATE
	 ********************************************************************************************************/

	@Override
	public int addPatientDetails(PatientBean patient)
	{
		// TODO Auto-generated method stub
		IPatientDAO patientObj=new PatientDAO();
		int patient_sequence=patientObj.addPatientDetails(patient);
		
		return patient_sequence;
	}

	/*******************************************************************************************************
	 - Function Name	:	searchPatientDetails
	 - Input Parameters	:	patient id
	 - Return Type		:	list
	 - Throws			:  	PatientException
	 - Author			:	IGATE
	 ********************************************************************************************************/

	@Override
	public List<PatientBean> searchPatientDetails(String patientId) throws PatientException 
	{
		// TODO Auto-generated method stub
		List<PatientBean> list=new ArrayList<>();
		IPatientDAO patientObj=new PatientDAO();
		list=patientObj.searchPatientDetails(patientId);
		
		return list;
	}

	@Override
	public boolean isValid(PatientBean patientDetailsObj) throws PatientException
	{
		// TODO Auto-generated method stub
		boolean validname=isValidName( patientDetailsObj.getPatientName());
		boolean validage=isValidAge( patientDetailsObj.getAge());
		boolean validphn=isValidPhn( patientDetailsObj.getPhoneNum());
		boolean validdescrip=isValidDescription( patientDetailsObj.getDescription());
		if(validname&& validage&&validphn&&validdescrip)
		{
			return true;
		}
		
		
		return false;
	}

	private boolean isValidDescription(String description) throws PatientException 
	{
		// TODO Auto-generated method stub
		String descripPattern="^[a-zA-Z]{0,80}$";
		Pattern patternDescribe=Pattern.compile(descripPattern);
		Matcher matchName=patternDescribe.matcher(description);
		if(!matchName.find())
		{
			throw new PatientException("enter only alphabets");
		}
		return true;
	}

	private boolean isValidName(String customerName) throws PatientException 
	{
		// TODO Auto-generated method stub
		
		String namePattern="^[A-Z][a-zA-Z]{4,20}$";
		Pattern patternName=Pattern.compile(namePattern);
		Matcher matchName=patternName.matcher(customerName);
		if(!matchName.find())
		{
			throw new PatientException("enter a valid name with starting capital letter");
		}
		return true;
	}
	
	private boolean isValidAge(String age) throws PatientException 
	{
		// TODO Auto-generated method stub
		
		String agePattern="^[0-99]{2}$";
		Pattern patternAge=Pattern.compile(agePattern);
		Matcher matchName=patternAge.matcher(age);
		if(!matchName.find())
		{
			throw new PatientException("enter a valid age");
		}
		return true;
	}
	
	private boolean isValidPhn(String description) throws PatientException 
	{
		// TODO Auto-generated method stub
		
		String phonePattern="^[0-9]{10}$";
		Pattern patternPhone=Pattern.compile(phonePattern);
		Matcher matchPhone=patternPhone.matcher(description);
		if(!matchPhone.find())
		{
			throw new PatientException("enter a valid phone number");
		}
		return true;
	}
}
