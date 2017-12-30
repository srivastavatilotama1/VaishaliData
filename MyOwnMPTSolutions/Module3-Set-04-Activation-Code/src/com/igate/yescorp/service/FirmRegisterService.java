package com.igate.yescorp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.igate.yescorp.bean.FirmBean;
import com.igate.yescorp.dao.FirmRegistratiionDAOImpl;
import com.igate.yescorp.exception.FirmException;

public class FirmRegisterService implements IFirmRegisterService {

	@Override
	public boolean registerFirm(FirmBean firmBean) throws FirmException {
		// TODO Auto-generated method stub
		return new FirmRegistratiionDAOImpl().registerFirm(firmBean);
	}
	
	public int getActivationCode(){
		
		int number;
		Random random=new Random();
		while(true){
			number=random.nextInt(100000);
			if(number>10001){
				break;
			}
		}
		return number;
	}

	@Override
	public void activateAccount(String emailId) throws FirmException {
		// TODO Auto-generated method stub
		new FirmRegistratiionDAOImpl().activateAccount(emailId);
	}

	@Override
	public List<String> isValid(FirmBean firmBean) {
		// TODO Auto-generated method stub
		List<String> errorList=new ArrayList<String>();
		
		Pattern pattern = null;
		Matcher matcher = null;

		// Owner Name Validation
		pattern = Pattern.compile("^[A-Za-z\\s]{3,25}$");
		matcher = pattern.matcher(firmBean.getOwnerName());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Name");
		}

		// Phone Number Validation
		pattern=Pattern.compile("[1-9]{10}");
		matcher = pattern.matcher(firmBean.getMobileNumber());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Phone Number");
		}
		// Business name Validation
		pattern = Pattern.compile("^[A-Za-z0-9\\s,./]{3,}$");
		matcher = pattern.matcher(firmBean.getBusinessName());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Address");
		}
		pattern = Pattern.compile("^[a-z][a-z0-9]+@[a-z]+.[a-z]{2,3}$");
		matcher = pattern.matcher(firmBean.getEmail());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Email id");
		}
		
		return errorList;
	}
	
}
