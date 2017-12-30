package com.igate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.igate.dto.UserDto;
import com.igate.exception.UsersException;
import com.igate.util.DbUtil;

public class UserDaoImpl implements UserDao
{
	Connection con=null;
	PreparedStatement pst1=null;
	PreparedStatement pst2=null;
	PreparedStatement pst3=null;
	ResultSet rs=null;
	ResultSet rs2=null;

	@Override
	public void insertUsers(UserDto userDTO) throws UsersException 
	{
		con=DbUtil.getConnection();

		System.out.println(" Conneted in insertUsers.............");
		try
		{
			con.setAutoCommit(false);

			pst1=con.prepareStatement("insert into users values(?,?,?,?)");
			pst1.setString(1, userDTO.getName());
			pst1.setString(2,userDTO.getUsername());
			pst1.setString(3, userDTO.getPassword());
			pst1.setString(4, userDTO.getMobilenumber());
			int noOfRec1=pst1.executeUpdate();
			System.out.println(" Data is inserted  successfully in  users table");

			pst2=con.prepareStatement("insert into bills values(?,?)");
			pst2.setString(1, userDTO.getMobilenumber());
			pst2.setDouble(2,userDTO.getBillamount());			
			int noOfRec2=pst2.executeUpdate();	

			System.out.println(" Data is inserted  successfully in  bilss table");
			con.commit();
		} 
		catch (SQLException e)
		{			
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{					
				throw new UsersException("some exception in insert User method"+e1.getMessage()  );
			}	
			throw new UsersException("some exception in insert User method"+e.getMessage()  );

		}
		finally
		{
			try 
			{

				pst1.close();
				pst2.close();
				con.close();				
			} 
			catch (SQLException e)
			{
				throw new UsersException("some exception while closing objects "+e.getMessage()  );
			}
		}	

	}

	@Override
	public int updateAmt(Integer amt,UserDto userDTOt) throws UsersException
	{
		con=DbUtil.getConnection();
		int  newamt=0;

		System.out.println(" Conneted in updateAmt.............");
		try
		{
			con.setAutoCommit(false);

			pst1=con.prepareStatement("select billamount from bills where mobilenumber=?");
			pst1.setString(1, userDTOt.getMobilenumber());
			rs=pst1.executeQuery();
			rs.next();
			int oldbillamt=rs.getInt(1);
			System.out.println(" bill amount is selected  successfully "+oldbillamt);

			newamt=oldbillamt-amt.intValue();
			pst2=con.prepareStatement("update   bills set billamount =? where  mobilenumber=?");
			pst2.setInt(1, newamt);
			pst2.setString(2, userDTOt.getMobilenumber());
			int noOfRec2=pst2.executeUpdate();	

			System.out.println(" New Amt is updated  successfully in  bilss table");
			con.commit();
		} 
		catch (SQLException e)
		{			
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{					
				throw new UsersException("some exception in insert User method"+e1.getMessage()  );
			}	
			throw new UsersException("some exception in insert User method"+e.getMessage()  );

		}
		finally
		{
			try 
			{

				pst1.close();
				pst2.close();
				con.close();				
			} 
			catch (SQLException e)
			{
				throw new UsersException("some exception while closing objects "+e.getMessage()  );
			}
		}	

		return newamt;
	}


	public ArrayList<String> getUsers()throws UsersException
	{
		con=DbUtil.getConnection();
		ArrayList<String> userList=new ArrayList<String>();
		System.out.println(" Conneted in getUsers.............");
		try
		{
			con.setAutoCommit(false);
			pst1=con.prepareStatement("select username from users");				
			rs=pst1.executeQuery();
			while(rs.next())
			{
				userList.add(rs.getString(1));					
			}
			con.commit();
		} 
		catch (SQLException e)
		{			
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{					
				throw new UsersException("some exception in insert User method"+e1.getMessage()  );
			}	
			throw new UsersException("some exception in insert User method"+e.getMessage()  );

		}
		finally
		{
			try 
			{

				pst1.close();
				rs.close();
				con.close();				
			} 
			catch (SQLException e)
			{
				throw new UsersException("some exception while closing objects "+e.getMessage()  );
			}
		}	
		System.out.println("success..............");

		return userList;		 
	}

	public UserDto getBillAmt(String username)throws UsersException
	{
		UserDto userDto=new UserDto();
		con=DbUtil.getConnection();		
		System.out.println(" Conneted in getBillAmt............."+username);
		try
		{
			 con.setAutoCommit(false);
			pst1=con.prepareStatement("select * from users where username=?");				
			pst1.setString(1, username);
			rs=pst1.executeQuery();			
				System.out.println("Result set ............."+rs);
			while(rs.next())
			{						
				userDto.setName(rs.getString(1));
				userDto.setUsername(rs.getString(2));
				userDto.setPassword(rs.getString(3));				
				userDto.setMobilenumber(rs.getString(4));
			}	
			System.out.println("after while.............");
			pst2=con.prepareStatement("select * from bills where mobilenumber=?");
			pst2.setString(1, userDto.getMobilenumber());
			rs2=pst2.executeQuery();
			rs2.next();
			userDto.setBillamount(rs2.getInt(2));
			
			System.out.println("  user............. "+userDto);
			con.commit();
		} 
		catch (SQLException e)
		{			
			try 
			{
				
				con.rollback();
			}
			catch (SQLException e1) 
			{					
				throw new UsersException("some exception in getBillAmt method"+e1.getMessage()  );
			}	
			throw new UsersException("some exception in getBillAmt method"+e.getMessage()  );

		}
		finally
		{
			try 
			{

				pst1.close();
				pst2.close();
				rs2.close();
				rs.close();
				con.close();				
			} 
			catch (SQLException e)
			{
				throw new UsersException("some exception while closing objects "+e.getMessage()  );
			}
		}	
		System.out.println("success..............");

		return userDto;		 
	}

}
