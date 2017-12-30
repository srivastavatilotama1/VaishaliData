package com.igate.jdbc;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igate.bean.Employee;
import com.igate.dao.EmployeeDAO;


public class JdbcClient {


	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		EmployeeDAO empDAO = (EmployeeDAO) context.getBean("empDAO");
		/* Employee springEmp = new Employee(77,"Abhi Srivastava", 7000);
        empDAO.insertEmployee(springEmp);
        System.out.println(" **********Employee Inserted************* ");*/

		String name=empDAO.getEmployeeName(1111);
		System.out.println("Name "+name);
		System.out.println(" **********Employee  Fetched Using ID ************* ");

			
		//execute update (modify)
		int update=empDAO.updateEmp(1111, "Rakesh Sharma", 77777.77);
		if(update>0)
			System.out.println("Update Success");
		else
			System.out.println("Update Failed");

		System.out.println(" **********Employee  Updated ************* ");


		Employee employee=empDAO.getEmpByEid(77);
		System.out.println("Employee Info");
		System.out.println("EID :"+employee.getEid());
		System.out.println("ENM :"+employee.getEnm());
		System.out.println("ESL :"+employee.getEsl());

		System.out.println(" **********Employee  Fetched Using Id********* ");

		List<Employee> eList=empDAO.getEmployeeList();
		System.out.println("List of Employees");
		for(Employee e:eList)
			System.out.println(e.getEid()+" "+e.getEnm()+" "+e.getEsl());

	}

}
