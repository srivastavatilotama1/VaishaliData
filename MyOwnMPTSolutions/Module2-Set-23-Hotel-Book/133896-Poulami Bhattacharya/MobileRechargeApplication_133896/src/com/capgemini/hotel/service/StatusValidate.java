package com.capgemini.hotel.service;

public class StatusValidate {
	public String setStatus(String roomNo)
	{
		if(roomNo.equals("101"))
		{
			
			return "Booked";
		}
		else if(roomNo.equals("102"))
		{
			return "Booked";
		}
		else if(roomNo.equals("103"))
		{
			return "Booked";
		}
		else if(roomNo.equals("201"))
		{
			return "NOT Booked";
		}
		else if(roomNo.equals("202"))
		{
			return "NOT Booked";
		}
		else if(roomNo.equals("203"))
		{
			return "NOT Booked";
		}
		else
			return "Invalid Room number";
	}
}
