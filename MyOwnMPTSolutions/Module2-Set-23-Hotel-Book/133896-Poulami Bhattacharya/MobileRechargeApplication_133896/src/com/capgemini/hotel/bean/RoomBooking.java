package com.capgemini.hotel.bean;


import java.time.LocalDate;

public class RoomBooking {
	
	private String roomNo;
	private String roomType;
	private String status;
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RoomBooking [roomNo=" + roomNo + ", roomType=" + roomType
				+ ", status=" + status + "]";
	}
	

	
}
