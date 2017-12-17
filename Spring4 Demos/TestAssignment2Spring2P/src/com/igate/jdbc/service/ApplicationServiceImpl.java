package com.igate.jdbc.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	{			
		LocalDate applicationDate=LocalDate.parse(application.getApplicationDateText(),
				DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		application.setAppliedDate(applicationDate);
		return dao.insertApplication(application);
	}
	@Override
	public List<Application> getAllApplicationDetails()			
	{
		return dao.getAllApplicationDetails();
	}
	@Override
	public int getAppCount() {	
		return dao.getAppCount();
	}
	@Override
	public String getApplicantName(int appId) {
		
		return dao.getApplicantName(appId);
	}
	@Override
	public int updateApp(Application app) {		
		return dao.updateApp(app);
	}
	@Override
	public Application getAppByAppId(int appId) {	
		return dao.getAppByappId(appId);
	}

}
