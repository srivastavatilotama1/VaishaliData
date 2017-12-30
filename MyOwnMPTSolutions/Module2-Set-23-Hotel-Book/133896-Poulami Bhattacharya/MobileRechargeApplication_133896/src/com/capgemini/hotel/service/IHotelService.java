package com.capgemini.hotel.service;

import java.util.ArrayList;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.exception.HotelBookingException;

public interface IHotelService {
	
	public int addCustomerDetails(CustomerBean bean) throws HotelBookingException;
	public ArrayList<RoomBooking> getBookingDetails(int CustomerId) throws HotelBookingException;
	
	
	public boolean isValidName(String name);
	public boolean isValidMailId(String mailId);
	public boolean isValidAddress(String address);
	public boolean isValidPhone(String phone);
	public boolean isValidRoomNo(String roomNo);
	public String setRoomType(String roomNo);
	//public boolean isValidRoomType(String roomtype);
	//public boolean isValidName(String name);

}
