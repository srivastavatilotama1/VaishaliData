package com.cg.appl.dto;

import java.sql.Date;

public class ShowDetails {
	private String showid;
	private String showname;
	private String location;
	private java.sql.Date showdate;
	private int avseats ;
	private double priceticket;
	public ShowDetails(String showid, String showname, String location,
			Date showdate, int avseats, double priceticket) {
		super();
		this.showid = showid;
		this.showname = showname;
		this.location = location;
		this.showdate = showdate;
		this.avseats = avseats;
		this.priceticket = priceticket;
	}
	
	public ShowDetails(String showid, String showname, int avseats,
			double priceticket) {
		super();
		this.showid = showid;
		this.showname = showname;
		this.avseats = avseats;
		this.priceticket = priceticket;
	}

	public String getShowid() {
		return showid;
	}
	public void setShowid(String showid) {
		this.showid = showid;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public java.sql.Date getShowdate() {
		return showdate;
	}
	public void setShowdate(java.sql.Date showdate) {
		this.showdate = showdate;
	}
	public int getAvseats() {
		return avseats;
	}
	public void setAvseats(int avseats) {
		this.avseats = avseats;
	}
	public double getPriceticket() {
		return priceticket;
	}
	public void setPriceticket(double priceticket) {
		this.priceticket = priceticket;
	}
	@Override
	public String toString() {
		return "ShowDetails [showid=" + showid + ", showname=" + showname
				+ ", location=" + location + ", showdate=" + showdate
				+ ", avseats=" + avseats + ", priceticket=" + priceticket + "]";
	}

}
