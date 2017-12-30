package com.test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.ContactService;
import com.test.vo.Contact;
import com.test.vo.ContactVO;



public class TestContact {
	
	public static void main(String args[]){
		
		ContactService contactService ;
		
		 		
    	ApplicationContext appContext = 
      	  new ClassPathXmlApplicationContext("applicationContext.xml");

	    
	    contactService = (ContactService) appContext.getBean("contactService");
	    
	    Contact contact = new ContactVO();
	    contact.setFirstName("Suprity");
	    contact.setLastName("Pahani");
	    contact.setEmail("supi@xxx.com");
	    System.out.println("here***********");
	    contactService.addContactInformation(contact);
	    System.out.println("record added");

	

	}
}
