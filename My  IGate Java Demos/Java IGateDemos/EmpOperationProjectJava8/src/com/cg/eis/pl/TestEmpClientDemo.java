package com.cg.eis.pl;
import java.time.LocalDate;
import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmpServiceImpl;
import com.cg.eis.service.IEmpService;
public class TestEmpClientDemo
{
	static Scanner sc=new Scanner(System.in);	
	static IEmpService empService=new
			EmpServiceImpl();
	public static void main(String[] args)
	{		
		int choice=0;

		while(true)
		{
			System.out.println
			("Type :\n 1:Add\t 2:Update\t"+
					"3:Dispaly Emp By Id \t 4:Get Experience Of Emp "+
					"\t 5:Exit");	
			System.out.println(" Enter UR Choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				Employee empDetails=
				enterEmpDetails();	
				try 
				{
					empService.addEmployee(empDetails);
				} 
				catch (EmployeeException e)
				{							
					e.printStackTrace();
				}
				break;
			case 3:
					System.out.println("Enter Emp Id To Search :");
					int eid=sc.nextInt();
					Employee ee=empService.fetchEmployeeDetailsById(eid);
					System.out.println("Info Is : "+ee);
					System.out.println(" Experience Is : "+
							ee.getExperience(ee.getDateOfJoin()));
					break;

			default:System.exit(0);
			}			
		}
	}
	private static Employee enterEmpDetails()
	{
		Employee ee=null;
		System.out.println(" Enter Emp Name: ");
		String nm=sc.next();
		int id=0;
		float sal=0.0F;

		if(empService.validateEmpName(nm))
		{			
			System.out.println(" Enter Salary: ");
			sal=sc.nextFloat();	
			System.out.println(" Enter DOJ In dd-mmm-yyyy");
			String empDOJ=sc.next();
			LocalDate empLocalDOJ=empService.convertStrToLocalDate(empDOJ);
			ee=new Employee();
			ee.setEmpName(nm);
			ee.setEmpSal(sal);
			ee.setDateOfJoin(empLocalDOJ);
			return ee;
		}
		else
		{
			return enterEmpDetails();
		}	

	}

}
