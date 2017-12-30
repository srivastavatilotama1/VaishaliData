package com.igate.eis.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.igate.eis.bean.Employee;
import com.igate.eis.service.EmployeeService;
import com.igate.eis.service.EmployeeServiceImpl;

public class TestInsuranceDemo
{
	static Scanner sc=new Scanner(System.in);
	static EmployeeService es=new EmployeeServiceImpl();
	public static void main(String[] args)
	{	
		boolean flag=true;
		Employee eArr[];
		int choice;

		while(true)
		{
			System.out.println("\n\t\tWhat Do U Want To Do?");
			System.out.println("\t\t\t 1: add Employee  DEATAILS");
			System.out.println("\t\t\t 2:delete Employee ");
			System.out.println("\t\t\t 3: Sort Employee ");
			System.out.println("\t\t\t 4: SEARCH Emp By Scheme ");
			System.out.println("\t\t\t 5: display  All Emp  ");
			System.out.println("\t\t\t 0: EXIT");
			System.out.print(" Please Enter Your Choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:enterEmpDetails();
					break;	
				case 2:deleteEmp();
					break;	
				case 3:sortEmp();
				break;							
				case 4:
					BufferedReader br=new BufferedReader(
						new InputStreamReader(System.in));
					System.out.println(" Enter Insurance Scheme");
					String scheme=null;
					try 
					{
						scheme = br.readLine();
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					searchByScheme(scheme);
				break;	
			case 5:es.dispEmps();
			break;	
			default:System.exit(0);			
			}				
		}
	}
	private static void searchByScheme(String scheme)
	{
		es.searchEmpByScheme(scheme);
		
	}
	private static void sortEmp()
	{
		es.sortEmpBySal();
		
	}
	private static void deleteEmp() 
	{
		es.dispEmps();
		System.out.println("\n\t\tWhich Emp U want To delete:");
		int id=sc.nextInt();
		es.deleteEmployees(id);
		
	}
	public static void enterEmpDetails()
	{
		boolean flag=true;

		while(flag)
		{			
			try 
			{

				System.out.print("\t\t Enter empId:");
				int empId=sc.nextInt();

				System.out.print("\t\t Enter Name:");
				String name=sc.next();

				System.out.print("\t\tEnter Salary: ");				
				float sal=sc.nextFloat();

				Employee	ee=new  Employee(empId,name,sal);
				es.addEmployee(ee);

				System.out.println("\t\t\tDo you want enter more Emp details ? Y: YES N: NO");

				String ch=sc.next();
				if( ch.equalsIgnoreCase("y"))
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			} 
			catch (Exception e)
			{				
				e.printStackTrace();
			} 			
		}

	}

}
