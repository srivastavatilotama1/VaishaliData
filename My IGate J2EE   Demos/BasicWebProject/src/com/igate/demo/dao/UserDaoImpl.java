package com.igate.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.igate.demo.exception.LoginException;

import com.igate.demo.dto.LoginDTO;
import com.igate.demo.util.DBUtil;

public class UserDaoImpl implements IUserDao
{
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st=null;

	@Override
	public ArrayList<LoginDTO> getAllUsers() 
	throws LoginException
	{
		con=DBUtil.getConnection();
		System.out.println(" In dao Got Con Obj "+con);
		String selectQry=
			"select *  FROM userinfo ";
		LoginDTO loginDto=null;
		ArrayList<LoginDTO> userList=new ArrayList<LoginDTO>();
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while (rs.next())
			{
				loginDto=new LoginDTO(rs.getString("user_name"),
						rs.getString("password"));
				userList.add(loginDto);
			}
			
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}
		finally
		{
			try
			{
				con.close();
				st.close();
				rs.close();				
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new LoginException(e.getMessage());
			}
			
		}
		
		return userList;
	}

	@Override
	public LoginDTO getUserInfo(String username)
	{
		
		return null;
	}

}
