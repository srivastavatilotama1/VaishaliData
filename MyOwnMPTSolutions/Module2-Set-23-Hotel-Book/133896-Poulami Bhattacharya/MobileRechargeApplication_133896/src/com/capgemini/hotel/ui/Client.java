package com.capgemini.hotel.ui;



import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.exception.HotelBookingException;
import com.capgemini.hotel.service.IHotelService;
import com.capgemini.hotel.service.HotelService;
import com.capgemini.hotel.service.RoomTypeValidate;
import com.capgemini.hotel.service.StatusValidate;


public class Client {

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./resources/log4j.properties");
		
		IHotelService service=new HotelService();
		
		Scanner sc=new Scanner(System.in);
		
		CustomerBean cb=new CustomerBean();
		
		RoomBooking rv=new RoomBooking();
		StatusValidate sv=new StatusValidate();
		System.out.println(".....Menu.....");
		System.out.println("1.Book Room");
		System.out.println("2.view Booking Status");
		System.out.println("3.exit");
		System.out.println("Select option");
		
		int op=sc.nextInt();
		
		switch(op)
		{
		
		case 1:
			
			do{
				System.out.println("Enter Custormer Name:");
				String custName=sc.next();
				
				boolean res=service.isValidName(custName);
				if(res==true)
				{
					cb.setCustName(custName);
					break;
				}
				else
					System.out.println("Invalid Name");
			}while(true);
			
			do{
				System.out.println("enter mail id:");
				String mailId=sc.next();
				
				boolean res=service.isValidMailId(mailId);
				if(res)
				{
					cb.seteMail(mailId);
					break;
				}
				else
					System.out.println("Invalid mail");
			}while(true);
			
			do{
				System.out.println("Enter Address:");
				String address=sc.next();
				
				boolean res=service.isValidAddress( address);
				if(res)
				{
					cb.setCustAddress(address);
					break;
				}
				else
					System.out.println("Invalid  address");
			}while(true);
			do{
				System.out.println("Enter Mobile Number:");
				String mobno=sc.next();
				
				boolean res=service.isValidPhone( mobno);
				if(res)
				{
					cb.setMobileNo(mobno);
					break;
				}
				else
					System.out.println("Invalid  mobile number");
			}while(true);
			
			
			do{
				System.out.println("Room No:");
				String roomNo=sc.next();
				
				boolean res=service.isValidRoomNo(roomNo);
				if(res)
				{
					cb.setRoomNo(roomNo);
					
					rv.setStatus(sv.setStatus(roomNo));
					break;
				}
				else
					System.out.println("Invalid  room number");
			}while(true);
			do{
				System.out.println("Room Type:");
				String roomType=sc.next();
				
				String res=service.setRoomType(roomType);
				if(res != null)
				{
					cb.setRoomType(roomType);
					
					break;
				}
				else
					System.out.println("Invalid Room type");
			}while(true);
			
			try {
				int CustomerId=service.addCustomerDetails(cb);
				System.out.println("Your Room has been successfully booked, your Customer ID is:"+CustomerId);
				
			} 
			catch (HotelBookingException e) {
				System.out.println(e.getMessage());
			
			}
			
			
				
			break;
			
		case 2:
			System.out.println("Enter Cutomer Id: ");
			int custId=sc.nextInt();
			
			try {
				ArrayList<RoomBooking> roomList=service.getBookingDetails(custId);
				for(RoomBooking room: roomList)
				{
					CustomerBean cc=new CustomerBean();
					System.out.println(cc.getCustName()+""+room.getRoomNo()+""+room.getRoomType()+""+room.getStatus());
					
					
				}
				
				
				
			} catch (HotelBookingException e) {
				
				System.out.println(e.getMessage());
			}
			
			
			break;
			
		case 5:
			System.exit(0);
			
			
		}
		
	}

}
