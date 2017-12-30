

/********************************************************************************
 * File					:Complaint.java
 * Author Name			:96121
 * Description			:Complaint Bean class with validations,constructors,getters,setters
 * 						 and toString method
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="complaint")
public class Complaint 
{
	@Id
	@Column(name="complaintid")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="complaintIdGen")
	@SequenceGenerator(name="complaintIdGen",sequenceName="hibernate_complaint_id_seq")
	private int complaintId;
	
	@Column(name="accountid")
	@Min(value=1000000000l,message="Account Id should be atleast 10 digits")
	@Max(value=9999999999l,message="Account Id should be atleast 10 digits")
	private long accountId;
	
	
	@Column(name="branchcode")
	@Size(min=4,max=10,message="Please enter Brach code between 4-10 alpha-numeric value")
	private String branchCode;
	
	@Column(name="emailid")
	@Email(message="Email Id not valid")
	@Size(min=10,max=30,message="Please enter your email Id between 10-30 characters")
	private String emailId;
	
	@Column(name="category")
	private String category;
	
	
	@Column(name="description")
	@Size(min=10,max=100,message="Please describe your complain in 10-100 characters")
	private String description;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="status")
	private String status;
	
	public Complaint() 
	{
		
	}

	public Complaint(int complaintId, long accountId, String branchCode,
			String emailId, String category, String description,
			String priority, String status) {
		super();
		this.complaintId = complaintId;
		this.accountId = accountId;
		this.branchCode = branchCode;
		this.emailId = emailId;
		this.category = category;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", accountId="
				+ accountId + ", branchCode=" + branchCode + ", emailId="
				+ emailId + ", category=" + category + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}
	
}
