package com.cg.car.dto;

import java.time.LocalDate;

public class Booking {
	private int bookingId;
	private String name;
	private String mobileNumber;
	private String email;
	private String address;
	private LocalDate BookingDate;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		BookingDate = bookingDate;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId, String name, String mobileNumber,
			String email, String address, LocalDate bookingDate) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		BookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", name=" + name
				+ ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", address=" + address + ", BookingDate=" + BookingDate + "]";
	}
	
	
	
	
	

}
