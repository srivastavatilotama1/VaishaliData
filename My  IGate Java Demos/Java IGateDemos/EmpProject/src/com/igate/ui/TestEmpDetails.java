package com.igate.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import com.igate.bean.Emp;
import com.igate.exception.EmpException;
import com.igate.service.EmpServiceImpl;
import com.igate.service.IEmpService;
public class TestEmpDetails
{	
	static IEmpService empService=new EmpServiceImpl();
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner (System.in);
		int choice=0;

		while(true)
		{
			System.out.println("Do U Want To Continue?");
			System.out.println("1:Insert Emp In Table \t2:Display All Emp From table\t3:EXIT");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:enterEmpDetails();
			break;
			case 2: dispAllEmp();break;
			default:
				System.exit(0);
			}
		}
	}

	private static void dispAllEmp() 
	{
		ArrayList<Emp> eList=empService.getAllEmp();
		//System.out.println(eList);
		Iterator<Emp> empIt=eList.iterator();
		while(empIt.hasNext())
		{
			System.out.println(empIt.next());
		}
		
	}

	private static void enterEmpDetails() 
	{
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try 
		{			
			System.out.println(" Enter UR ID : ");
			String id=br.readLine();
			
			if(empService.validateEmpId(id))
			{
				int eid=Integer.parseInt(id);
				
				System.out.println(" Enter UR Name :");
				String name=br.readLine();

				System.out.println(" Enter UR Salary :");
				float sal=Float.parseFloat(br.readLine());

				System.out.println(" Enter Gender :");
				char gen=br.readLine().charAt(0);
				
				System.out.println(" U Entered  : "+" ID :\t"+eid+" Name :\t"+name+" Salary :\t"+sal+" Gender :\t"+gen);
					
				System.out.println("Enter Date Of Birth : ");
				
				System.out.println(" Enter day :");
				int day=(Integer.parseInt(br.readLine()));
				
				System.out.println(" Enter mon :");
				int mon=(Integer.parseInt(br.readLine()));
				
				System.out.println(" Enter year :");
				int year=(Integer.parseInt(br.readLine()));
				
				GregorianCalendar tempDob=
					new GregorianCalendar(year,mon,day);
				Date tempSqlDob=new Date(((tempDob.getTime()).getTime()));
				
				Emp tempE = new Emp(eid, name, sal, gen,tempSqlDob);
				
				empService.addAllEmp(tempE);
				System.out.println("*****All Emp entered*****");
			}
		}
		catch(EmpException empExp)
		{
			empExp.printStackTrace();
		}
		catch (Exception e) 
		{			
			e.printStackTrace();
		} 
	}
}
