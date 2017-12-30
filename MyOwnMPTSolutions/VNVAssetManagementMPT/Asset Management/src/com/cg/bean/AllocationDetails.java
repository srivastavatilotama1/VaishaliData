/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To provide getters and setters for asset details

package com.cg.bean;

import java.time.LocalDate;

public class AllocationDetails {

	
	private String assetName;
	private String allocationType;
	private String empNumber;
	private LocalDate currentDate;
	private long allocationId;

	//default constructor
	public AllocationDetails() {

	}
	
	//initializing instance variables
	public AllocationDetails(String assetName, String allocationType,String empNo, LocalDate currentDate, long allocationId ) {
		this.assetName = assetName;
		this.allocationType = allocationType;
		this.empNumber = empNo;
		this.currentDate = currentDate;
		this.allocationId = allocationId;
	}
	
	//getter for allocation id
	public long getAllocationId() {
		return allocationId;
	}
	//setter for allocation id
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	//getter for asset name
	public String getAssetName() {
		return assetName;
	}
	//setter for asset name
	public void setAseetName(String assetName) {
		this.assetName = assetName;
	}
	//getter for allocation type
	public String getAllocationType() {
		return allocationType;
	}
	//setter for allocation type
	public void setAllocationType(String allocationType) {
		this.allocationType = allocationType;
	}
	//setter for employee number
	public void set(String empNumber) {
		this.empNumber = empNumber;
	}
	//getter for employee number
		public String getempNumber() {
			return empNumber;
	}
	//setter for current date
	public LocalDate getcurrentDate() {
		return currentDate;
	}
	//setter for current date
	public void setcurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}
	//displaying asset details 
	@Override
	public String toString() {
		return "Asset [AllocationId=" + allocationId + ", Asset Name="
				+ assetName + ", Allocation Type=" + allocationType +", Employee Number=" + empNumber
				+ ", Allocation Date=" + currentDate + "]";
	}



}
