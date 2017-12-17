package com.igate.jdbc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.exception.ApplicationException;
@Repository("dao")
public class ApplicationDAOImpl extends JdbcDaoSupport 
implements IApplicationDAO
{
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

		System.out.println(" App obj is ..............."+application);

		LocalDate appliedDate=application.getAppliedDate();
		java.sql.Date appliedSqlDate=java.sql.Date.valueOf(appliedDate);

		String sql="INSERT INTO applications "
				+ "VALUES(application_id_seq.NEXTVAL,?,?,?,?,?,?)";   
		Object[] params=new Object[]{					
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

	@Override
	public int getAppCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getApplicantName(int appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateApp(Application app) {
		System.out.println(" In edit App....dao......"+app);
		String sql="update applications set "+
		"username=?,emailid=?,mobilenumber=?"+
		" where applicationId=?";
		Object[] params = new Object[]
		    {
				app.getUsername(),
				app.getEmailId(),
				app.getMobileNumber(),
				app.getApplicationId()
				};
		
		
				int update=getJdbcTemplate().update(sql, params);
		return update;
	}

	@Override
	public Application getAppByappId(int appId) {
		String sql = "SELECT * from applications where applicationid=?";

		RowMapper mapper = new RowMapper() 
		{
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				
				Application app = new Application();
				app.setApplicationId(rs.getInt(1));
				app.setUsername(rs.getString("username"));
				app.setMobileNumber(rs.getString("mobilenumber"));
				app.setEmailId(rs.getString("emailid"));
				System.out.println(rowNum);
				return app;
			}
		};

		Application app= (Application) getJdbcTemplate().queryForObject(sql,mapper,appId);
		return app;

	}
}

