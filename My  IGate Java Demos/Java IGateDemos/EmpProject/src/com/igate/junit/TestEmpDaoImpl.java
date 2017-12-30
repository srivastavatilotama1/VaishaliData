package com.igate.junit;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.igate.bean.Emp;
import com.igate.dao.EmpDaoImpl;
import com.igate.exception.EmpException;


public class TestEmpDaoImpl
{
	@Test
	public void testingViewAllEmployees2()
	{
		System.out.println("from testingViewAllEmployees	");
		EmpDaoImpl empDAO= new EmpDaoImpl();
		ArrayList<Emp> eList;
		try
		{
			eList = empDAO.getAllEmp();
			Assert.assertEquals(8,eList.size());
		} 
		catch (EmpException e) 
		{			
			e.printStackTrace();
		}
	}
	@Test(expected=EmpException.class)
	public void testingViewAllEmployees3()
	{
		System.out.println("from testingViewAllEmployees	");
		EmpDaoImpl empDAO= new EmpDaoImpl();
		ArrayList<Emp> eList;
		eList = empDAO.getAllEmp();
		//Assert.assertEquals(14,eList.size());

		//Testing that eList contains 14 rows. Assume table contains 14 rows, test would 
	}
}
