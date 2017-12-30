package com.igate.yescorp.dao;

import com.igate.yescorp.bean.FirmBean;
import com.igate.yescorp.exception.FirmException;

public interface IFirmRegisterDAO {
	public boolean registerFirm(FirmBean firmBean) throws FirmException;
	public void activateAccount(String emailId) throws FirmException;
}
