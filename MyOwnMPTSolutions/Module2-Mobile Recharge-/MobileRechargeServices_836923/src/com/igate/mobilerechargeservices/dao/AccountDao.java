package com.igate.mobilerechargeservices.dao;

import com.igate.mobilerechargeservices.beans.Account;
import com.igate.mobilerechargeservices.exception.MobileServicesException;

public interface AccountDao {
	
	Account getAccount(String accountId) throws MobileServicesException;
		int rechargeAccount(String accountId, double rechargeAmt) throws MobileServicesException;
	

}
