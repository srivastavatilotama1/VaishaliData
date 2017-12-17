package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("offAdd")
public class Address 
{
//	@Value("MS")
	private String state;
	
//	@Value("India")
	private String country;
	
	
	//@Value("67877")
	private String zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@Autowired
	//@Qualifier("city1")
	private City city;
	
	
	@Override
	public String toString() {
		return "Address [state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + ", myCity=" + city + "]";
	}
	public Address(String state, String country, String zipcode, City city) {
		super();
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.city = city;
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
