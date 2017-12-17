package com.igate.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.dao.ApplicationDAOImpl;
import com.igate.jdbc.dao.IApplicationDAO;
import com.igate.jdbc.exception.ApplicationException;
@Service("service")
public class ApplicationServiceImpl 
implements IApplicationService
{
	@Autowired
 IApplicationDAO dao;
	@Override
	public int insertApplication(Application application)
			//throws ApplicationException 
	{
		return dao.insertApplication(application);
	}

	@Override
	public List<Application> getAllApplicationDetails()
			//throws ApplicationException 
	{
		return dao.getAllApplicationDetails();
	}

}
