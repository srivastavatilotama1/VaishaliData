package com.igate.aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDao implements EmployeeIntfc,ConnectionAware{
	
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Employee getEmployee(int id)
	{
		Employee employee =null;
		
		try
		{
		String qry="select * from employee414 where eid=?";
		PreparedStatement pst=connection.prepareStatement(qry);
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		
		  if(rs.next())
		  {
			employee=new Employee();
			employee.setEid(rs.getInt(1));
			employee.setEnm(rs.getString(2));
			employee.setEsl(rs.getDouble(3));
		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return employee ;
	}
	
	public void removeConnection()
	{
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
