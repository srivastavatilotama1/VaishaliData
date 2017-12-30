package com.cg.eis.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmpServiceImpl;
import com.cg.eis.util.DBUtil;
public class EmpDaoImpl  implements IEmpDao
{
	Logger myLogger=null;
	Connection con=null;
	PreparedStatement pst=null;
	Statement st=null;
	ResultSet rs=null;
	public EmpDaoImpl()
	{
		PropertyConfigurator.configure("resources/log4j.properties");
		myLogger=Logger.getLogger("EmpDaoImpl.class");
	}
	@Override
	public int addEmployee(Employee emp) throws
	EmployeeException
	{	
		Date sqlDoj= new EmpServiceImpl().
				convertToSQLDate(emp.getDateOfJoin());
		con=DBUtil.getCon();
		System.out.println
		("In Dao Class addEmployee  Con is :"+con);

		String insertEmpQry="INSERT INTO vai_emp("+
				"emp_id,emp_name,emp_sal,emp_doj)VALUES(vai_emp_seq.nextval,?,?,?)";
		int dataInserted=0;
		try 
		{
			pst=con.prepareStatement(insertEmpQry);
			pst.setString(1, emp.getEmpName());
			pst.setFloat(2, emp.getEmpSal());
			pst.setDate(3, sqlDoj);
			dataInserted=pst.executeUpdate();
			System.out.println("Data Is added in the table");
			myLogger.info("Emp Info : "+emp);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			myLogger.error(e.getMessage());
			throw new EmployeeException(e.getMessage());			
		}
		finally
		{
			try
			{
				pst.close();
				con.close();
				System.out.println(" All Connection Close");
			}
			catch (SQLException e) 
			{			
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}			
		}		
		return dataInserted;
	}
	@Override
	public Employee fetchEmployeeDetailsById(int empId) 
	{	
		Employee ee=null;
		con=DBUtil.getCon();
		System.out.println
		("In Dao Class fetchEmployeeDetailsById  Con is :"+con);
		String selectEmpQry="SELECT * from vai_emp WHERE emp_id=?";
	
		try 
		{
			pst=con.prepareStatement(selectEmpQry);
			pst.setInt(1, empId);			
			rs=pst.executeQuery();
			rs.next();
			ee=new Employee();
			ee.setEmpId(rs.getInt("emp_id"));
			ee.setEmpName(rs.getString("emp_name"));
			ee.setEmpSal(rs.getInt("emp_sal"));
			Date sqlDOJ=rs.getDate("emp_doj");
			LocalDate localDOJ=new EmpServiceImpl().convertToLocalDate(sqlDOJ);
			ee.setDateOfJoin(localDOJ);
			System.out.println("Data Is Fetched in the table");
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		//	myLogger.error(e.getMessage());						
		}
		finally
		{
			try
			{
				pst.close();
				con.close();
				System.out.println(" All Connection Close");
			}
			catch (SQLException e) 
			{			
				e.printStackTrace();
			}			
		}		
		return ee;
	}
	@Override
	public Employee updateEmpSal(int empId, float newSalary) 
	{		
		return null;
	}
	@Override
	public Date getDOJ(int empId)
	{		
		return null;
	}

}
