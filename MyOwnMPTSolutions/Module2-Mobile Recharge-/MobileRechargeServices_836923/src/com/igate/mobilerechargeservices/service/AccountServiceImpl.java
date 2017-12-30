package com.igate.mobilerechargeservices.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.igate.mobilerechargeservices.beans.Account;
import com.igate.mobilerechargeservices.dao.AccountDao;
import com.igate.mobilerechargeservices.dao.AccountDaoImpl;
import com.igate.mobilerechargeservices.exception.MobileServicesException;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao =new AccountDaoImpl();
	
	
	/********************************************************************
	*Function Name   :getAccount
	*Input Parameters:accountId
	*Return type     :Account
	*Author          :Ajay Rawat
	*Creation Date   :Oct 15, 2015
	*Description     :getAccount Service function for validation of accoountId
	********************************************************************/
	@Override
	public Account getAccount(String accountId) throws MobileServicesException {
		// TODO Auto-generated method stub
		
		Pattern p1=Pattern.compile("^[0-9]{3}$");
		Matcher m1=p1.matcher(accountId);
		if(m1.matches())
		{		
		return accountDao.getAccount(accountId);
	}
		else
		{
			throw  new MobileServicesException("Please enter Account Id in correct format");
		}
	}

	
	/********************************************************************
	*Function Name   :rechargeAccount
	*Input Parameters:accountId, scheme
	*Return type     :boolean
	*Author          :Ajay Rawat
	*Creation Date   :Oct 15, 2015
	*Description     :rechargeAccount Service function for validations
	********************************************************************/
	@Override
	public int rechargeAccount(String accountId, double rechargeAmt)
			throws MobileServicesException {
		// TODO Auto-generated method stub
		boolean valid=false;	
		
		Pattern patternAccountId=Pattern.compile("^[0-9]{3}$");
		Matcher matchAcountId=patternAccountId.matcher(accountId);
		
		
		String patternScheme = "^[0-9]{1,}$";		
		Pattern patternScheme1=Pattern.compile(patternScheme);
		
		//Matcher matchScheme=patternScheme1.matcher(scheme);
		
			
		
		
		
		//if(valid)
		//{
		return accountDao.rechargeAccount(accountId,rechargeAmt);
		//}
		//else
		//	return false;
		
	}
}
