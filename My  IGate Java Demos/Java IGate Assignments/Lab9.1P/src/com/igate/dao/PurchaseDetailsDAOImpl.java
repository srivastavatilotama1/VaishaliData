package com.igate.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import com.igate.dto.MobileDTO;
import com.igate.dto.PurchaseDetailsDTO;
import com.igate.exception.InvalidDataException;
import com.igate.util.DBUtil;



public class PurchaseDetailsDAOImpl  implements PurchaseDetailsDAO
{
	Connection con=DBUtil.getConnection();
	PreparedStatement updatePst=null;
	PreparedStatement pst;
	ResultSet rs=null;
	@Override
	public void addPurchaseDetails(PurchaseDetailsDTO purchaseDetailsDto)throws InvalidDataException 
	{		
		/** create sequence Seq_Purchase_ID
		start with 100
			INCREMENT By 1
				maxvalue 1000
				nocycle

		 */
		

		Calendar currenttime = Calendar.getInstance();
		Date sqlCurrDate = new Date((currenttime.getTime()).getTime());
		

		try
		{			
			  pst=
				con.prepareStatement
				("insert into purchasedetails values(Seq_Purchase_ID.NEXTVAL,?,?,?,?,?)");

			pst.setString(1, purchaseDetailsDto.getCustName());
			pst.setString (2,purchaseDetailsDto.getMailId());
			pst.setLong(3,purchaseDetailsDto.getPhoneNo());
			pst.setDate(4, sqlCurrDate);
			pst.setInt(5,purchaseDetailsDto.getMobileId());		
			
			int ii=pst.executeUpdate();
			System.out.println("Data is inserted  and table   :"+ii + "  ");
			con.commit();
		} 
		//
		catch (SQLException e)
		{
			throw new  InvalidDataException(e.getMessage());
		}
		finally
		{
			try 
			{
				con.close();
				rs.close();
			} catch (SQLException e) 
			{
				throw new  InvalidDataException(e.getMessage());
				
				
			}
		}


	}

	@Override
	public void deletePurchaseDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PurchaseDetailsDTO> getPurchaseDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MobileDTO getPurchaseDetailsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePurchaseDetails() {
		// TODO Auto-generated method stub

	}

}
