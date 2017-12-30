package com.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entities.ContactEO;


@Repository
public class ContactDAO {
    
	@PersistenceContext
    private EntityManager entityManagerFactory;
    
    
	@Transactional(readOnly = false)
    public void addContact(ContactEO contactEO){

		this.entityManagerFactory.persist(contactEO);
    }
    
}
