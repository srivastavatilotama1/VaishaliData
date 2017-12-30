package com.igate.mobilerechargeservices.service;

import com.igate.mobilerechargeservices.beans.Account;
import com.igate.mobilerechargeservices.exception.MobileServicesException;

public interface AccountService {

	Account getAccount(String accountId) throws MobileServicesException;
	int rechargeAccount(String accountId, double rechargeAmt) throws MobileServicesException;
}
