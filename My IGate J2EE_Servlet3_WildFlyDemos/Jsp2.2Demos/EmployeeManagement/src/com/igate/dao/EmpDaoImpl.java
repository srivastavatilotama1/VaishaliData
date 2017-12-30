package com.igate.dao;

import java.sql.*;
import java.util.ArrayList;
import com.igate.dto.Employee;
import com.igate.exception.EmployeeException;
import com.igate.util.DbUtil;

public class EmpDaoImpl  implements IEmpDao
{
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	@Override
	public int generateEmpId() throws EmployeeException 
	{	
		int generatedEmpId;
		con=DbUtil.getConnection();
		String seqQuery="SELECT  seq_emp.NEXTVAL FROM DUAL";
		try 
		{
			st=con.createStatement();
			rs=st.executeQuery(seqQuery);
			rs.next();
			generatedEmpId=rs.getInt(1);
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
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}		
		return generatedEmpId;
	}

	@Override
	public int inserEmp(Employee employeeDto) throws EmployeeException {
		
		con=DbUtil.getConnection();
		int inserted=0;
		String insertQuery="INSERT INTO employee414 VALUES(?,?,?)";
		try
		{
			pst=con.prepareStatement(insertQuery);
			
			pst.setInt(1, employeeDto.getEid());
			pst.setString(2, employeeDto.getEname());
			pst.setInt(3, employeeDto.getEsal());
			
			inserted =pst.executeUpdate();
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
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}
		return inserted;
	}

	@Override
	public ArrayList<Employee> getAllEmp() throws EmployeeException {
	
		
		con=DbUtil.getConnection();
		ArrayList<Employee> empList=new ArrayList<Employee>();
		String selectAllEmpQuery="SELECT * FROM employee414";
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selectAllEmpQuery);
			while(rs.next())
			{
				Employee emp=new Employee(
					rs.getInt("eid"),
					rs.getString("enm"),
					rs.getInt("esal"));				
				empList.add(emp);
			}
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
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}
		return empList;
	}

}
