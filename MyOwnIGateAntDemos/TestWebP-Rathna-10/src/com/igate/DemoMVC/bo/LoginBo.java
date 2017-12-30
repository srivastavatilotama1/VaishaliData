package com.igate.DemoMVC.bo;

import com.igate.DemoMVC.bean.LoginBean;
import com.igate.DemoMVC.dao.LogindaoImpl;
import com.igate.DemoMVC.exception.UserException;

public class LoginBo implements LoginInterface {

	@Override
	public boolean isUserPresent(LoginBean user) throws UserException  {
		LogindaoImpl logdao=new LogindaoImpl();
		System.out.println(user.getUsername()+" In LoginBo..................... in boii:"+
				user.getUsername()  + "  :  "				+
				user.getPassword());
		return logdao.isUserPresent(user);
	}

}
