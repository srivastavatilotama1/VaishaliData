package com.igate.tcc.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.tcc.bean.PatientBean;
import com.igate.tcc.exception.PatientException;
import com.igate.tcc.service.IPatientService;
import com.igate.tcc.service.PatientService;

public class Client 
{
	
	public static void main(String[] args)  
	{
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();
		PropertyConfigurator.configure("resources/log4j.properties");
		PatientBean patientDetailsObj=null;
		IPatientService patientObj=new PatientService();
		Scanner scan=new Scanner(System.in);
		String choice="";
		while(!choice.equalsIgnoreCase("no"))
		{
			System.out.println("Enter your choice.");
			System.out.println("1.Insert the patient details.");
			System.out.println("2.Search details of a patient");
			System.out.println("3.Exit");
			choice=scan.next();
			int patientIdseq;
			
				switch(choice)
				{
				case "1": 
					System.out.println("Please Enter patient details");
					System.out.print("Enter your name:");
					String name=scan.next();
					System.out.print("Enter your age:");
					String age=scan.next();
					System.out.print("Enter your phone number:");
					String phoneNumber=scan.next();
					System.out.print("Enter the description");
					String description=scan.next();
					patientDetailsObj=new PatientBean(name,age,phoneNumber,description);
				
					boolean result=false;
				
					try 
					{
						result=patientObj.isValid(patientDetailsObj);
					} 
					catch (PatientException e)
					{
					// TODO Auto-generated catch block
						System.err.println("Details are invalid"+e);
					
					}
					if(result==true)
					{
						patientIdseq=patientObj.addPatientDetails(patientDetailsObj);
						System.out.println("Patient Information stored succeessfully and your patient id is"+patientIdseq);
					
					}
				break;
				case "2":
					System.out.print("Enter patient id:");
					String patientId=scan.next();
					List<PatientBean> list=new ArrayList<>();
					try {
						list=patientObj.searchPatientDetails(patientId);
						System.out.println("Name of the Patient"+"    "+" Age"+"   "+"PhoneNumber"+"   "+"Description"+"     "+"Consultation Date");
						list.stream().map(patient -> patient.getPatientName()+"                   "+patient.getAge()+"     "+patient.getPhoneNum()+"     "+patient.getDescription()+"    "+patient.getConsultationDate()).forEach(System.out::println);
						logger.info("Patient Details found"); 
						}
					catch (PatientException e)
					{
						// TODO Auto-generated catch block
						logger.error("Exception occured while viewing details"+e);
						System.err.println("Error while viewing"+e);
					}
					break;
				case "3":
					System.exit(0);	
					break;
				}
		System.out.println("Do you want to continue? yes/no");
		choice=scan.next();
		}
	}
}
	


