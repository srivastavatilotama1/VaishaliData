package com.igate.jdbc.service;

import java.util.List;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.exception.ApplicationException;

public interface IApplicationService {

	public int insertApplication(Application application) ; 
			//throws ApplicationException;
	
	public List<Application> getAllApplicationDetails();
			//throws ApplicationException;
}
