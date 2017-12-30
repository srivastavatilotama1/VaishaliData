package com.igate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.igate.dto.LoginDTO;
import com.igate.exception.LoginException;
import com.igate.util.DbUtil;

public class UserDaoImpl implements IUserDao
{
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st=null;
	String pattern = "MM/dd/yyyy";	
	SimpleDateFormat format = new SimpleDateFormat(pattern);

	@Override
	public ArrayList<LoginDTO> getAllUsers() throws LoginException
	
	{
		con=DbUtil.getConnection();
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
		
		con=DbUtil.getConnection();
		System.out.println(" In dao Got Con Obj "+con);
		String selectQry=
			"select *  FROM userinfo where user_name=? ";
		LoginDTO loginDto=null;
		java.util.Date utilDOB=null;
		
	
		try
		{
			pst=con.prepareStatement(selectQry);
			pst.setString(1, username);
			rs=pst.executeQuery();
			System.out.println(" Rs Not Null :"+rs);
			rs.next();
			utilDOB=new
			java.util.Date((rs.getDate("DOB").getTime()));
			String birthDate=format.format(utilDOB);			
				loginDto=new LoginDTO(rs.getString("user_name"),
						rs.getString("password"));	
				System.out.println("In Dao :..........."+loginDto);		
					
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
			return loginDto;	
	}


	@Override
	public int addUser(LoginDTO loginDto) 
	{
		String birthDate=loginDto.getDob();
		java.util.Date birthDateUtil=null;
		
		try 
		{
			birthDateUtil = format.parse(birthDate);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Util DOB............."+birthDateUtil);		
		
		java.sql.Date sqlDOB=new java.sql.Date(birthDateUtil.getYear(),
				birthDateUtil.getMonth(),birthDateUtil.getDate());
		
		System.out.println("In   Dao sql DOB is ......."+sqlDOB);
			
		int status=0;
		con=DbUtil.getConnection();
		System.out.println(" In addUser Got Con Obj "+con);
		String insertQry=
			"INSERT into UserInfo values(?,?,?,?,?,?)";
		try
		{
			pst=con.prepareStatement(insertQry);
			pst.setString(1, loginDto.getUserName());
			pst.setString(2, loginDto.getPassword());
			pst.setString(3, loginDto.getFirstName());
			pst.setString(4, loginDto.getLastName());
			pst.setLong(5, loginDto.getPhoneNo());
			pst.setDate(6, sqlDOB);
			
			status=pst.executeUpdate();
			System.out.println(" data Inserted successfully" );
								
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
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new LoginException(e.getMessage());
			}			
		}
			return status;	
	}

	@Override
	public int getCount(String username)
	{
		con=DbUtil.getConnection();
		System.out.println(" In dao getCount Got Con Obj "+con);
		String selectQry=
			"select count(*) FROM userinfo where user_name=? ";
		int count=0;		
		try
		{
			pst=con.prepareStatement(selectQry);
			pst.setString(1, username);
			rs=pst.executeQuery();
			System.out.println(" Rs Not Null :"+rs);
			rs.next();	
			count=rs.getInt(1);					
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
		return count;	
		
	}
}
