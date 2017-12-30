package com.igate.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


import org.apache.log4j.Logger;

import com.igate.bean.Emp;
import com.igate.exception.EmpException;
import com.igate.log.IGateLogger;
import com.igate.util.DBUtil;

public class EmpDaoImpl  implements IEmpDao
{
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Logger  igateLogger=null;
	public int getEmpRowCount()
	{
		int count=0;
		try 
		{
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery("select count(*) from emp_821219");
			rs.next();
			 count=rs.getInt(1);
			System.out.println(" No Of Records : "+count);			
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		finally
		{
			try
			{
			rs.close();
			st.close();
			con.close();	
			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
		}
		return count;		
	}
	
	
	
	
	
	
	
	@Override
	public void insertEmp(Emp emp) throws EmpException 
	{		
		//GregorianCalendar geDob=emp.getDob();
		//java.sql.Date sqlDateDob=
		//	new java.sql.Date((geDob.getTime()).getTime());
		igateLogger=IGateLogger.getIGateLogger();
		System.out.println(" Logger  .........."+igateLogger);
		con=DBUtil.getCon();
		System.out.println(" In Insert Method Of EmpDao +"+con);
		String insertQry="insert into emp_821219 values(?,?,?,?,?)";
		try 
		{
			pst=con.prepareStatement(insertQry);
			pst.setInt(1, emp.getEid());
			pst.setString(2, emp.getEmpname());
			pst.setFloat(3, emp.getSal());			
			pst.setString(4,String.valueOf(emp.getGen()));
			pst.setDate(5, emp.getDob());
			int noOfRec=pst.executeUpdate();
			System.out.println(" Data is inserted In Table");
				
			igateLogger.info(" Emp :"+emp+
					" Was inserted in Table  On "+
					new Date());
		} 
		catch (SQLException e)
		{	
			igateLogger.error("Exception Occored While Insertion "+
					e+" On :"+	new Date());
			throw new EmpException(e.getMessage());
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
				igateLogger.error("Exception Occored While Insertion "+
						e+" On :"+	new Date());
				throw new EmpException(e.getMessage());
			}
		}	
	}
	@Override
	public ArrayList<Emp> getAllEmp() throws EmpException
	{	
		ArrayList<Emp> empList=new ArrayList();
		Emp empArr[]=new Emp[getEmpRowCount()];
		try 
		{
			con=DBUtil.getCon();	
			st=con.createStatement();
			String selectQry="SELECT * from emp_821219";
			rs=st.executeQuery(selectQry);
			rs.next();
			for(int j=0;j<empArr.length;j++)
			{
				java.sql.Date td=rs.getDate(5);
				System.out.println(td +"....................");
				java.util.Date dd=new java.util.Date((td.getTime()));
				System.out.println("dd ......."+dd);
				empArr[j]=new Emp(rs.getInt(1),
						rs.getString(2),
						rs.getFloat(3),
						rs.getString(4).charAt(0),
						rs.getDate(5));
				//add obj in  arraylist
				empList.add(empArr[j]);
				rs.next();				
			}			
		}
		catch (SQLException e) 
		{
			throw new EmpException(e.getMessage());
		}
		
		return empList;
	}
	@Override
	public Emp getEmpById(int eid) throws EmpException
	{		
		return null;
	}

}
