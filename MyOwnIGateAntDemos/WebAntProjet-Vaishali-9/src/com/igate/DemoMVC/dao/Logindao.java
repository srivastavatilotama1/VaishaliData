package com.igate.DemoMVC.dao;

import com.igate.DemoMVC.bean.LoginBean;
import com.igate.DemoMVC.exception.UserException;

public interface Logindao {
	boolean isUserPresent(LoginBean user)throws UserException ;
}
