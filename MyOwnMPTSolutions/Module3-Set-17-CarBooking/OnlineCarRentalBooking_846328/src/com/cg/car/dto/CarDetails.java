package com.cg.car.dto;

public class CarDetails {
	
	private String carNumber;
	private String carCategory;
	private int hirePrice;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarCategory() {
		return carCategory;
	}
	public void setCarCategory(String carCategory) {
		this.carCategory = carCategory;
	}
	public int getHirePrice() {
		return hirePrice;
	}
	public void setHirePrice(int hirePrice) {
		this.hirePrice = hirePrice;
	}
	public CarDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarDetails(String carNumber, String carCategory, int hirePrice) {
		super();
		this.carNumber = carNumber;
		this.carCategory = carCategory;
		this.hirePrice = hirePrice;
	}
	@Override
	public String toString() {
		return "CarDetails [carNumber=" + carNumber + ", carCategory="
				+ carCategory + ", hirePrice=" + hirePrice + "]";
	}
	
	
	

}
