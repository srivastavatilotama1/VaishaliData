package com.capgemini.hotel.bean;

public class CustomerBean {
	
	private String custName;
	private String eMail;
	private String custAddress;
	private String mobileNo;
	private String roomType;
	private String roomNo;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	@Override
	public String toString() {
		return "CustomerBean [custName=" + custName + ", eMail=" + eMail
				+ ", custAddress=" + custAddress + ", mobileNo=" + mobileNo
				+ ", roomType=" + roomType + ", roomNo=" + roomNo + "]";
	}
	
	
}
