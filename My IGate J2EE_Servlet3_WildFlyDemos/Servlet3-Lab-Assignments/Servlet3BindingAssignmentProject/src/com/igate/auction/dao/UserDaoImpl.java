package com.igate.auction.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.igate.auction.dto.LoginDTO;
import com.igate.auction.exception.LoginException;
import com.igate.auction.util.DBUtil;


public class UserDaoImpl implements IUserDao
{
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st=null;

	@Override
	public ArrayList<LoginDTO> getAllUsers() 	throws LoginException
	{
		con=DBUtil.getConnection();
		System.out.println(" In UserDaoImpl dao Got Con Obj "+con);
		String selectQry=
				"select *  FROM vaishali_user ";
		LoginDTO loginDto=null;
		ArrayList<LoginDTO> userList=new ArrayList<LoginDTO>();
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while (rs.next())
			{
				loginDto=new LoginDTO(rs.getString("uname"),
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
		String selectUNameQry="select uname from vaishali_user";
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(selectUNameQry);

			while(rs.next())
			{
				userNameList.add(rs.getString("uname"));
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
		String insertQry="insert into vaishali_user values(?,?)";
		try
		{
			pst=con.prepareStatement(insertQry);
			pst.setString(1, loginDto.getUserName());
			pst.setString(2,loginDto.getPassword());			

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

	public boolean isValidUser(LoginDTO loginDto) 
	{
		con=DBUtil.getConnection();
		System.out.println(" In  isValidUser  UserDaoImpl dao Got Con Obj "+con);
		String selectQry=
				"select *  FROM vaishali_user where uname=? ";
		boolean flag=false;
		try
		{
			pst=con.prepareStatement(selectQry);
			pst.setString(1, loginDto.getUserName());

			rs=pst.executeQuery();
			rs.next();
			if(rs.getString(2).equalsIgnoreCase(loginDto.getPassword()))
			{
				flag=true;
			}
			else
			{
				flag=false;
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
				pst.close();
				rs.close();				
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new LoginException(e.getMessage());
			}

		}

		return flag;
	}
}
