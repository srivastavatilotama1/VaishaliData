package com.test.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.test.dao.ContactDAO;
import com.test.entities.ContactEO;
import com.test.vo.Contact;

public class ContactServiceImpl implements ContactService{
	@Autowired
	ContactDAO contactDAO;
	
	
	
	
	//@Transactional(readOnly = false)
	public void addContactInformation(Contact contact){
		try {
			// construct the Entity bean 
			ContactEO contactEO = new ContactEO(contact);
			
			// save it
			contactDAO.addContact(contactEO);
		} catch (DataAccessException e) {
			System.out.println("error occured*******************************************************" + e.getMessage());
	
		}
		catch(Exception e){
			System.out.println("*****************************************in gneric exception "+e.getMessage());
		}
	}
}
