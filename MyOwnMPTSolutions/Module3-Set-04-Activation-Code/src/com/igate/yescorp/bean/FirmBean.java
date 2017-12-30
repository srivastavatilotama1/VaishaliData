package com.igate.yescorp.bean;

public class FirmBean {
	private long firmId;
	private String ownerName;
	private String businessName;
	private String email;
	private String mobileNumber;
	private String isActive;
	public long getFirmId() {
		return firmId;
	}
	public void setFirmId(long firmId) {
		this.firmId = firmId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public FirmBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
