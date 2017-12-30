package com.igate.DemoMVC.bo;

import com.igate.DemoMVC.bean.LoginBean;
import com.igate.DemoMVC.exception.UserException;

public interface LoginInterface {
	
	boolean isUserPresent(LoginBean user)throws UserException ;

}
