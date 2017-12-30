package com.capgemini.hotel.service;



public class RoomTypeValidate {
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
