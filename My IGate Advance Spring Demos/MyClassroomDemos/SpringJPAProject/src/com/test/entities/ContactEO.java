package com.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.*;
import com.test.vo.Contact;
import com.test.vo.ContactVO;

@Entity
@Table(name="contact")

public class ContactEO implements Contact{
	
	@Transient
	Contact contact;
	
	@Transient
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public ContactEO(){
		contact = new ContactVO();
	}
	
	public ContactEO(Contact contact){
		this.contact = contact;
	}
	
	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return contact.getFirstName();
	}
	
	public void setFirstName(String firstName) {
		contact.setFirstName(firstName);
	}
	
	@Column(name="LASTNAME")
	public String getLastName() {
		return contact.getLastName();
	}
	
	public void setLastName(String lastName) {
		contact.setLastName(lastName);
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return contact.getEmail();
	}
	public void setEmail(String email) {
		contact.setEmail(email);
	}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public long getId() {
		return contact.getId();
	}
	
	public void setId(long id) {
		contact.setId(id);
	}

	

}


