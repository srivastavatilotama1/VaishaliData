package com.cg.eis.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmpServiceImpl;
import com.cg.eis.util.DBUtil;
public class EmpDaoImpl  implements IEmpDao
{	
	Connection con=null;
	PreparedStatement pst=null;
	Statement st=null;
	ResultSet rs=null;
	public EmpDaoImpl(){}
	@Override
	public int addEmployee(Employee emp) throws
	EmployeeException
	{			
		con=DBUtil.getConnection();
		System.out.println
		("In Dao Class addEmployee  Con is :"+con);
		System.out.println
		("emp is is ..................:"+emp);

		String insertEmpQry="INSERT INTO emp("+
				"emp_id,emp_name)VALUES(?,?)";
		int dataInserted=0;
		try 
		{
			pst=con.prepareStatement(insertEmpQry);
			pst.setInt(1, emp.getEmpId());
			pst.setString(2, emp.getEmpName());			
			dataInserted=pst.executeUpdate();
			System.out.println("Data Is added in the table");			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
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
	public ArrayList<Employee> getAllEmp()
	{
		ArrayList<Employee> empList=new ArrayList<Employee>();
		
		String selctQry="SELECT * FROM emp";
		con=DBUtil.getConnection();
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selctQry);
			while(rs.next())
			{
				Employee ee=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"));
				empList.add(ee);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
		return empList;
	}

}
