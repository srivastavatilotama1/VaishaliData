package com.igate.jdbc.dao;

import java.util.List;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.exception.ApplicationException;

public interface IApplicationDAO 
{
	public int insertApplication(Application application) ; 
	public List<Application> getAllApplicationDetails();		

}
