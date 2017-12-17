package com.igate.jdbc.dao;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.jdbc.bean.Application;
@Repository("dao")
public class ApplicationDAOImpl extends JdbcDaoSupport 
implements IApplicationDAO{
	
	@Autowired
	private DataSource myDataSource;
	@PostConstruct
	private void initialize() 
	{
		setDataSource(myDataSource);
	}		
	
	@Override
	public int insertApplication(Application application)
			
	{
		LocalDate appliedDate=application.getAppliedDate();
		java.sql.Date appliedSqlDate=java.sql.Date.valueOf(appliedDate);
		
		 String sql="INSERT INTO applications VALUES(?,?,?,?,?,?,?)";   
			Object[] params=new Object[]{
					
					application.getApplicationId(),
					application.getUsername(),
					application.getEmailId(),
					application.getMobileNumber(),
					application.getCity(),
					appliedSqlDate,
					application.getAccountExists()
					};
			return getJdbcTemplate().update(sql, params);
				
	}
	@Override
	public List<Application> getAllApplicationDetails()
			
		{
		
		String sql="SELECT * FROM applications";
		 List<Application> applicationList =getJdbcTemplate().
				query(sql, (rs,rowNum) ->{
							Application application = new Application();
							application.setApplicationId(rs.getInt(1));
							application.setUsername(rs.getString(2));
							application.setEmailId(rs.getString(3));
							application.setMobileNumber(rs.getString(4));
							application.setCity(rs.getString(5));
							
							java.sql.Date appliedSqlDate=rs.getDate(6);
							
							LocalDate appliedDate=appliedSqlDate.toLocalDate();
							application.setAppliedDate(appliedDate);
							application.setAccountExists(rs.getString(7));
						
						return application;
				});
		return applicationList;
		
	}
}

