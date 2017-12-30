package com.igate.mobilerechargeservices.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.igate.mobilerechargeservices.exception.MobileServicesException;
import com.igate.mobilerechargeservices.service.AccountService;
import com.igate.mobilerechargeservices.service.AccountServiceImpl;


public class RechargeAccountTest {

	/********************************************************************
	*Function Name   :rechargeAccountTest
	*Input Parameters:void
	*Return type     :void
	*Author          :Ajay Rawat
	*Creation Date   :Oct 15, 2015
	*Description     : This is a test function to test rechargeAccount method
	********************************************************************/
	@Test
	public void rechargeAccountTest() throws MobileServicesException
	{
		AccountService accountService = new AccountServiceImpl();
		boolean test=accountService.rechargeAccount("101","EconomyPlan");
	
		assertEquals(true,test);
	}
}
