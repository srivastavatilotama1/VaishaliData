package com.capgemini.hotel.test;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.dao.ICustomerBookingDAO;
import com.capgemini.hotel.dao.CustomerBookingDAO;
import com.capgemini.hotel.exception.HotelBookingException;

public class HotelBookingTest {
	
	@Test
	public void testAddCustomer()
	{
		RoomBooking pd=new RoomBooking();
		CustomerBean cb=new CustomerBean();
		cb.setCustName("Poulmi");
		cb.seteMail("poulami.bhatta@capgemini.com");
		cb.setMobileNo("9087654367");
		cb.setRoomNo("101");
		cb.setRoomType("AC_SINGLE");
		
		
		ICustomerBookingDAO dao=new CustomerBookingDAO();
		
		try{
			int id=dao.addCustomerDetails(cb);
			
			Assert.assertTrue((id>0));
		}
		catch(HotelBookingException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
