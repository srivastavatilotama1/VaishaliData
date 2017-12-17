package com.cg.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="participants")
@SequenceGenerator(name="registrationid", initialValue=1, allocationSize=100)
public class Participants implements Serializable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="registrationid")
	@Column(name="registrationid ")
	private Long registrationId ;
	
	@NotEmpty(message=" Mandatory Name")
	@Pattern(regexp="[A-Za-z]+",
	message="Only Characters Allowed.")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message=" Mandatory Email Address")
	@Email(message=" Plaese enter valid email address")
	@Column(name="emailId")
	private String emailId;
	
	@NotEmpty(message=" Mandatory Mobile")
	@Pattern(regexp="[0-9]{10}",
	message="10 Digit Mobile No.")
	@Column(name="mobile")
	private String mobile;
	
	@NotEmpty(message=" Mandatory Address")
	@Pattern(regexp="[A-Za-z]+",
	message="Only Characters Allowed.")
	@Column(name="address")
	private String address;
	
	@Temporal(TemporalType.DATE) 
	@Column(name="registrationDate")
	private Date registrationDate;	
		
	@Column(name="workshopid")
	private long wid;

	public long getWid() {
		return wid;
	}

	public void setWid(long wid) {
		this.wid = wid;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	
	
}
