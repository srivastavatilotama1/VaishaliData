package com.igate.sample;

public class Customer {

	private int customerId;
	private String customerName;
	private String accountType;
	private String mobileNumber;
	
	
	public Customer() {
		
	}
	public Customer(int customerId, String customerName, String accountType,
			String mobileNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountType = accountType;
		this.mobileNumber = mobileNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", accountType=" + accountType
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
}
