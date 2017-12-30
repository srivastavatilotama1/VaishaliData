
/********************************************************************************
 * File					:CustomerDaoImpl.java
 * Author Name			:96121
 * Description			:Implementation of ICustomerDao interface methods
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.web.customercomplaintapp.entities.Complaint;
import com.cg.web.customercomplaintapp.exception.CustomerComplaintException;

@Repository
public class CustomerDaoImpl implements ICustomerDao
{

	@PersistenceContext
	EntityManager entityManager;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.cg.web.customercomplaintapp.dao.ICustomerDao#addCustomerComplaint(com.cg.web.customercomplaintapp.entities.Complaint)
	 * The method addCustomerComplaint accepts a Complaint bean object and inserts it into database
	 * using entityManager's persist method
	 * The method returns the unique complaint Id generated through sequence
	 */
	
	@Override
	public int addCustomerComplaint(Complaint complaint) throws CustomerComplaintException
	{
		try
		{
			entityManager.persist(complaint);
			return complaint.getComplaintId();
		}
		catch(CustomerComplaintException e)
		{
			throw new CustomerComplaintException("Complaint could not be registered");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.cg.web.customercomplaintapp.dao.ICustomerDao#getStatus(int)
	 * The method getStatus accepts complaint Id and fetches the record with provided complaint Id
	 * into a Complaint bean object using entityManager's find method
	 * The method returns a Complaint bean object
	 */
	
	@Override
	public Complaint getStatus(int complaintId) throws CustomerComplaintException
	{
		try
		{
			Complaint complaint=entityManager.find(Complaint.class,complaintId);
			return complaint;
		}
		catch(CustomerComplaintException e)
		{
			throw new CustomerComplaintException("Status could not be retrieved");
		}
	}

}
