
/********************************************************************************
 * File					:ICustomerService.java
 * Author Name			:96121
 * Description			:ICustomerService interface contains method declarations
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.service;

import com.cg.web.customercomplaintapp.entities.Complaint;
import com.cg.web.customercomplaintapp.exception.CustomerComplaintException;

public interface ICustomerService 
{
	public int addCustomerComplaint(Complaint complaint) throws CustomerComplaintException;
	public Complaint getStatus(int complaintId) throws CustomerComplaintException;
}
