package com.capgemini.hotel.dao;

import java.util.ArrayList;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.exception.HotelBookingException;

public interface ICustomerBookingDAO {
	
	
	
	
	public int addCustomerDetails(CustomerBean bean) throws HotelBookingException;
	
	public ArrayList<RoomBooking> getBookingDetails(int CustomerId) throws HotelBookingException;
	
	
	
	

}

