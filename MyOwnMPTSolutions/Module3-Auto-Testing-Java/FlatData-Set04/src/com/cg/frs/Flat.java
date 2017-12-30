package com.cg.frs;
public class Flat {
	
	private long flatRegistrationNo;
	private String firstName;
	private String lastName;
	private long MobileNo;
	private int flatType;
	private double rentAmt;
	private double depositAmt;
	
	
	public Flat() {
		
	}
	public Flat(String firstName, String lastName,
			long mobileNo, int flatType, double rentAmt, double depositAmt) {
		
		this.flatRegistrationNo = flatRegistrationNo;
		this.firstName = firstName;
		this.lastName = lastName;
		MobileNo = mobileNo;
		this.flatType = flatType;
		this.rentAmt = rentAmt;
		this.depositAmt = depositAmt;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public int getFlatType() {
		return flatType;
	}
	public void setFlatType(int flatType) {
		this.flatType = flatType;
	}
	public double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	public String Ownername(String Firstname,String Lastname){
		String name= Firstname +" " + Lastname;
		return name;
	}
	@Override
	public String toString() {
		return "Flat [ firstName=" + firstName + ", lastName=" + lastName
				+ ", MobileNo=" + MobileNo + ", flatType=" + flatType
				+ ", rentAmt=" + rentAmt + ", depositAmt=" + depositAmt + "]";
	}
	
	
	
	
	
}
