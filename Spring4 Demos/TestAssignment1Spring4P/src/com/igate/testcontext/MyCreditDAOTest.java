package com.igate.testcontext;

import java.time.LocalDate;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.dao.ApplicationDAOImpl;
import com.igate.jdbc.pl.JdbcClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcClient.class})
@ActiveProfiles("dev")
public class MyCreditDAOTest 
{
	Application application =null;		
	@Autowired
	private ApplicationDAOImpl applicationDAO;	
	@Before	
	public void setUp()
	{
		
		System.out.println(" In setUp Before each test..............");
		application=new Application();
		application.setApplicationId(201);
		application.setUsername("amit");
		application.setEmailId("amit@gmail.com");
		application.setMobileNumber("89899");
		application.setCity("city");
		application.setAppliedDate(LocalDate.of(1967, 9,13));
		application.setAccountExists("N");		
	}
	@Test
	public void testInsertApp()
	{		
		//System.out.println("in MyCreditDAOTest class ..........." +
		//		applicationDAO.insertApplication(application));
		Assert.assertEquals(1, applicationDAO.insertApplication(application));		
	}

	@Test
	public void testAllCreditDetails() 
	{
		System.out.println("in MyCreditDAOTest in testAllCreditDetails()"  );
		Assert.assertNotNull(applicationDAO.getAllApplicationDetails());
	}
}
