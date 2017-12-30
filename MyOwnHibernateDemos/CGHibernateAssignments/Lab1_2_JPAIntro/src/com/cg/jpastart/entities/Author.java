package com.cg.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//By Default name of the  table column should be 
// same as name of the property of bean class.
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
@NamedQuery(name = "getAllAuthors", 
query = "SELECT au FROM Author au"))

public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorId;
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", phoneNo=" + phoneNo + "]";
	}
	private String firstName;
	private String middleName;
	private String lastName;
	private long phoneNo;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}

