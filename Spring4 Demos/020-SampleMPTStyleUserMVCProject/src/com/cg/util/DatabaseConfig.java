package com.cg.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:oracle.properties")
@Profile("Dev")
public class DatabaseConfig 

{
	@Value("${db.driver}")
	public String driver;
	
	@Value("${db.url}")
	public String url;
	
	@Value("${db.username}")
	public String dbUserName;
	
	@Value("${db.password}")
	public String dbPwd;
		
	@Bean
	@Qualifier("dataSource")
	public  DataSource createDataSource()
	{
		DriverManagerDataSource dms=new DriverManagerDataSource();
		dms.setDriverClassName(driver);
		dms.setPassword(dbPwd);
		dms.setUrl(url);
		dms.setUsername(dbUserName);
		return dms;
		
	}

}
