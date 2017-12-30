
/********************************************************************************
 * File					:CustomerServiceImpl.java
 * Author Name			:96121
 * Description			:Implementation of ICustomerService interface methods
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.web.customercomplaintapp.dao.ICustomerDao;
import com.cg.web.customercomplaintapp.entities.Complaint;
import com.cg.web.customercomplaintapp.exception.CustomerComplaintException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerDao iCustomerDao;
	
	@Override
	public int addCustomerComplaint(Complaint complaint) throws CustomerComplaintException
	{
		return iCustomerDao.addCustomerComplaint(complaint);
	}

	@Override
	public Complaint getStatus(int complaintId) throws CustomerComplaintException
	{
		return iCustomerDao.getStatus(complaintId);
	}

}
