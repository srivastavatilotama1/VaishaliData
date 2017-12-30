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

	@Override
	public ArrayList<String> getAllUsersName()
	throws LoginException
	{
		ArrayList<String> userNameList=
			new ArrayList<String>();
		con=DBUtil.getConnection();
		String selectUNameQry="select user_name from userinfo";
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selectUNameQry);

			while(rs.next())
			{
				userNameList.add(rs.getString("user_name"));
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
				st.close();
				rs.close();
				con.close();


			} catch (SQLException e) 
			{				
				e.printStackTrace();
				throw new LoginException(e.getMessage());
			}

		}
		return userNameList;
	}

	@Override
	public int changePassword(String userName) throws LoginException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUserInfo(LoginDTO loginDto) throws LoginException {

		int noOfRec=0;
		con=DBUtil.getConnection();
		String insertQry="insert into userinfo values(?,?,?,?,?)";
		try
		{
			pst=con.prepareStatement(insertQry);
			pst.setString(1, loginDto.getUserName());
			pst.setString(2,loginDto.getPassword());
			pst.setString(3, loginDto.getFirstName());
			pst.setString(4, loginDto.getLastName());
			pst.setLong(5, loginDto.getPhoneNo());

			 noOfRec=pst.executeUpdate();
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
				pst.close();
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new LoginException(e.getMessage());
			}
		}
		return noOfRec;
	}

}
