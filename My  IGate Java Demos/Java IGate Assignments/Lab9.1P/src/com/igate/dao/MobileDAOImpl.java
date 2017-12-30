package com.igate.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.igate.dto.MobileDTO;
import com.igate.exception.InvalidDataException;
import com.igate.util.DBUtil;




public class MobileDAOImpl implements MobileDAO
{	
	Connection con=DBUtil.getConnection();
	PreparedStatement  updatePst,pst=null;
	ResultSet rs=null;
	Statement st;
	

	@Override
	public void addMobile() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMobile(int mobileId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<MobileDTO> getMobiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MobileDTO getMobileByPriceRange(int lowRange, int highRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMobileByQty(int newQty,int mobileId)throws InvalidDataException
	{
	
		 updatePst=null;
		int oldQty=0;
		try
		{
			con.setAutoCommit(false);
			oldQty=getMobileQty(mobileId);
			System.out.println(" Old qty  is .............."+ oldQty);
			updatePst=con.prepareStatement("update mobiles set quantity=?" +
			"Where mobileid=?");
			updatePst.setInt(1,(oldQty-newQty));
			updatePst.setInt(2,mobileId);

			int kk=updatePst.executeUpdate();
			con.commit();
			
			System.out.println("Data is updated   in table   : "  +kk);
		} 
		catch (SQLException e)
		{			
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{				
				throw new  InvalidDataException(e.getMessage());
			}
			
		}
		finally
		{
			try
			{
				con.close();
				updatePst.close();
				
			} catch (SQLException e) 
			{
				
				throw new  InvalidDataException(e.getMessage());
			}
			
		}

	}

	@Override
	public ArrayList<Integer> getMobileIds()throws InvalidDataException
	{
		
		ArrayList<Integer> mobilIdL=new ArrayList<Integer>();
		
		try
		{
			st=con.createStatement();				
			rs=st.executeQuery("select mobileid FROM mobiles");	
			while(rs.next())
			{
				mobilIdL.add(rs.getInt(1));
			}
			
		}
		catch (Exception e)
		{
			throw new  InvalidDataException(e.getMessage());
		}
		finally
		{
			try
			{
				con.close();
				st.close();
				rs.close();
				
			} catch (SQLException e) 
			{
				
				throw new  InvalidDataException(e.getMessage());
			}
			
		}

		return  mobilIdL;
	}

	@Override
	public int getMobileQty(int mobileId) throws InvalidDataException
	{
		
		int noOfQty=0;
		try
		{
			pst=con.prepareStatement("select quantity FROM mobiles where mobileid=?");	
			pst.setInt(1, mobileId);
			rs=pst.executeQuery();	
			rs.next();			
			noOfQty=rs.getInt(1);			
		}
		catch (Exception e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		finally
		{
			try
			{
				con.close();
				pst.close();
				rs.close();
				
			} catch (SQLException e) 
			{
				
				throw new  InvalidDataException(e.getMessage());
			}
			
		}
		return  noOfQty;		
	}
}
