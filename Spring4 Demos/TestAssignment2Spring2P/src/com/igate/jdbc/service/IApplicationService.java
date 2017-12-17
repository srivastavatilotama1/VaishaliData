package com.igate.jdbc.service;

import java.util.List;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.exception.ApplicationException;

public interface IApplicationService {

	public int insertApplication(Application application) ; 	
	public List<Application> getAllApplicationDetails();		
	public int getAppCount();	
	public String getApplicantName(int appId);	
	public int updateApp(Application app);
	public Application getAppByAppId(int appId) ;	
}
