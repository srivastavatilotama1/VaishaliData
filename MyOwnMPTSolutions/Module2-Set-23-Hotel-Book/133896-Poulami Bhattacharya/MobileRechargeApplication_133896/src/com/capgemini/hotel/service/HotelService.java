package com.capgemini.hotel.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.dao.ICustomerBookingDAO;
import com.capgemini.hotel.dao.CustomerBookingDAO;
import com.capgemini.hotel.exception.HotelBookingException;

public class HotelService implements IHotelService{

	ICustomerBookingDAO dao;
	public HotelService() {
	
	
		dao=new CustomerBookingDAO();
	}
	
	

	

	@Override
	public boolean isValidName(String name) {
		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern,name);
		
		return res;
	}

	@Override
	public boolean isValidPhone(String phone) {
		String pattern="[0-9]{10}";
		boolean res=Pattern.matches(pattern,phone);
		
		return res;
	}

	@Override
	public boolean isValidMailId(String mailId) {
		Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(mailId);
		
		if(matcher.find())
		{
			return true;
		}
		else
			return false;
	}







	@Override
	public int addCustomerDetails(CustomerBean bean)
			throws HotelBookingException {
		return dao.addCustomerDetails(bean);
	}





	@Override
	public ArrayList<RoomBooking> getBookingDetails(int CustomerId)
			throws HotelBookingException {
		return dao.getBookingDetails(CustomerId);
	}





	@Override
	public boolean isValidAddress(String address) {
		String pattern="[a-z]+";
		boolean res=Pattern.matches(pattern,address);
		
		return res;
	}





	@Override
	public boolean isValidRoomNo(String roomNo) {
		if(roomNo.equals("101")||roomNo.equals("102")||roomNo.equals("103")||roomNo.equals("201")||roomNo.equals("202")||roomNo.equals("203"))
		{
			return true;
		}
		else
			return false;
	}


	public String setRoomType(String roomNo)
	{
		if(roomNo.equals("101"))
		{
			return "AC_SINGLE";
		}
		else if(roomNo.equals("102"))
		{
			return "AC_SINGLE";
		}
		else if(roomNo.equals("103"))
		{
			return "AC_DOUBLE";
		}
		else if(roomNo.equals("201"))
		{
			return "NONAC_SINGLE";
		}
		else if(roomNo.equals("202"))
		{
			return "NONAC_SINGLE";
		}
		else if(roomNo.equals("203"))
		{
			return "NONAC_DOUBLE";
		}
		else
			return "Noooo";
	}


}
	
	


