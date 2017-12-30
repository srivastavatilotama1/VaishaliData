package com.capgemini.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.Scanner;


import org.apache.log4j.Logger;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.exception.HotelBookingException;

import com.capgemini.hotel.utility.DatabaseConnection;


public class CustomerBookingDAO implements ICustomerBookingDAO{
	Scanner sc=new Scanner(System.in);
	
	
	Logger logger=Logger.getLogger(CustomerBookingDAO.class);
	
	
	
	@Override
	public int addCustomerDetails(CustomerBean bean)
			throws HotelBookingException {
		int cid=0;
		Connection con=DatabaseConnection.getConnection();
		try{
			String insertQuery1="insert into RoomsDetail values(?,?,?)";
			String insertQuery="insert into CustomerDetails values(CustomerID_SEQ.nextval,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(insertQuery);
			PreparedStatement ps1=con.prepareStatement(insertQuery1);
			ps1.setInt(1, Integer.parseInt(bean.getRoomNo()));
			ps1.setString(2, bean.getRoomType());
			ps1.setString(3,"Booked");
			ps1.executeUpdate();
			
			ps.setString(1,bean.getCustName());
			ps.setString(2,bean.geteMail());
			ps.setString(3,bean.getCustAddress());
			ps.setString(4,bean.getMobileNo());
			ps.setString(5,bean.getRoomType());
			ps.setString(6,bean.getRoomNo());
			
			
					int row=ps.executeUpdate();
					System.out.println(row);
					if(row==1)
					{
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select CustomerID_SEQ.currval from dual");
						if(rs.next())
						{
							cid=rs.getInt(1);
							logger.info("customer id:"+cid);
							
							return cid;
						}
					}
			else
				throw new HotelBookingException("room not available");
		
	}
		

	catch(SQLException e)
	{
		e.printStackTrace();
		int errorCode=e.getErrorCode();
		logger.error(e.getMessage());
		if(errorCode==2291)
			throw new HotelBookingException("not possible");
		else
			throw new HotelBookingException(e.getMessage());
	}
		return 0;
	}

	

	
	@Override
	public ArrayList<RoomBooking> getBookingDetails(int CustomerId) throws HotelBookingException {
		
		ArrayList<RoomBooking> list=new ArrayList<>();
		String selectQuery="select CustName,RoomNo,RoomType,Status from RoomsDetail where CustID=?";
		try {
			Connection con= DatabaseConnection.getConnection();
			System.out.println("enter customer id:");
			
			int CustId=sc.nextInt();
			PreparedStatement ps=con.prepareStatement(selectQuery);
			ps.setInt(1,CustId);
			ResultSet rs=ps.executeQuery();
			
			
			
			while(rs.next())
			{
				RoomBooking rib=new RoomBooking();
				CustomerBean cb=new CustomerBean();
				
				cb.setCustName(rs.getString("CustName"));
				rib.setRoomNo(rs.getString("RoomNo"));
				rib.setRoomType(rs.getString("RoomType"));
				rib.setStatus(rs.getString("Status"));
				
				list.add(rib);
			}
			
				
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
				throw new HotelBookingException(e.getMessage());
			}
		return list;
	}
	
	}


	
	

