package com.cg.eis.junit;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmpDaoImpl;
import com.cg.eis.dao.IEmpDao;
import com.cg.eis.exception.EmployeeException;
public class EmpDaoImplTest
{
	static IEmpDao empDao;
	@BeforeClass
	public  static void initCode()
	{
		empDao=new EmpDaoImpl();
	}
	@Test
	public void testAddEmp()throws EmployeeException 
	{
		Employee ee1=new Employee();
		ee1.setEmpName("AAA");
		ee1.setEmpSal(2000.0F);

		Employee ee2=new Employee();
		ee2.setEmpName("BBB");
		ee2.setEmpSal(5000.0F);

		Assert.assertEquals(1, empDao.addEmployee(ee1));		
	}

}
