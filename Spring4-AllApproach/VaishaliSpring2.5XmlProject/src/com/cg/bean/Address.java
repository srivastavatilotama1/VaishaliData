package com.cg.bean;

public class Address 
{
	private String state;
	private String country;
	private String zipcode;
	private City city;
	@Override
	public String toString() {
		return "Address [state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + ", myCity=" + city + "]";
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	

}
