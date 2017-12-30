package com.igate.eis.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.igate.eis.bean.Employee;

public class EmployeeServiceImpl  implements EmployeeService
{
	static HashMap<String,Employee> empMap=new HashMap<String,Employee>();
	@Override
	public void addEmployee(Employee ee)
	{
		empMap.put(new Integer(ee.getEmpId()).toString(),ee);

	}

	@Override
	public void getEmploeesByScheme(String insuranceScheme) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployees(int empId)
	{
		String delKey=new String(new Integer(empId).toString());
		empMap.remove(delKey);
		System.out.println(" After Deletion :");
		dispEmps();

	}

	@Override
	public void sortEmp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispEmps() 
	{
		Set<Entry<String,Employee>> empSet=empMap.entrySet();
		 
		Iterator<Entry<String,Employee>> itSet=empSet.iterator();
		for(Entry<String,Employee> temp :empSet)
		{
			System.out.print(" \n "+temp.getKey()+"    :    ");
			System.out.print(temp.getValue());
		}
		
	}

	@Override
	public void sortEmpBySal()
	{
		TreeSet<Employee> empS=new TreeSet<Employee>();
		
		Set<Entry<String,Employee>> empSet=empMap.entrySet();
		 
		Iterator<Entry<String,Employee>> itSet=empSet.iterator();
		
		for(Entry<String,Employee> temp :empSet)
		{
			empS.add(temp.getValue());
		}
		
		System.out.println("\t\t   Sorted Emp according to salary ");
		for(Employee xx:empS)
		{
		
			System.out.println(" "+xx);
		}			
	}

	@Override
	public void searchEmpByScheme( String scheme) 
	{
		boolean flag=false;
		System.out.println(" U  R scheme enterexd is : "+scheme);
		Set<Entry<String,Employee>> empSet=empMap.entrySet();
		 
		Iterator<Entry<String,Employee>> itSet=empSet.iterator();
		for(Entry<String,Employee> temp :empSet)
		{
			Employee tempEmp=temp.getValue();
			if(tempEmp.getInsuranceScheme().equalsIgnoreCase(scheme))
			{
				System.out.println("\t\t\t"+temp.getValue());
				flag=true;
			}
			else
			{
				flag=false;
			}
		}
		if(flag)
		{
			System.out.println(" above is  list" );
		}
		else
		{
			System.out.println(" Given Scheme Emp Not Found" );
		}
		
	}
}
