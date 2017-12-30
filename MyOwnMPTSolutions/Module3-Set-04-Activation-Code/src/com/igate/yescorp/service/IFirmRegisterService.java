package com.igate.yescorp.service;

import java.util.List;

import com.igate.yescorp.bean.FirmBean;
import com.igate.yescorp.exception.FirmException;

public interface IFirmRegisterService {
	public boolean registerFirm(FirmBean firmBean) throws FirmException;
	public int getActivationCode();
	public List<String> isValid(FirmBean firmBean);
	public void activateAccount(String emailId) throws FirmException;
}
