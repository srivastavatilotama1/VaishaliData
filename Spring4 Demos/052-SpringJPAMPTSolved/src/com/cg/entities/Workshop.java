package com.cg.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="workshop")
public class Workshop implements Serializable {
	
	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="workshopId")
	private Long workshopId;
	
	@Column(name="name")
	private String workshopName;
	
	@Temporal(TemporalType.DATE) 
	@Column(name="Scheduledate")
	private Date schDate;
	
	
	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	@Column(name="venue")
	private String venue;	
	}
