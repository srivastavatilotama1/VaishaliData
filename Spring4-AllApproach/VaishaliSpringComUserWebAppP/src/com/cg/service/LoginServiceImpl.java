package com.cg.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;
import com.cg.dao.ILoginDao;
import com.cg.util.MyStringDateUtil;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements
ILoginService
{
	@Autowired
	ILoginDao loginDao;
	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public Login getUserByUserName(String un) {
	
		return loginDao.getUserByUserName(un);
	}

	@Override
	public boolean isValid(String un) {
	
		return false;
	}

	@Override
	public boolean isUserExist(String un) {
	
		return false;
	}

	@Override
	public RegisterDto addAllUserDeatils(RegisterDto regDto) {
	
		regDto.setDobUtilDate(MyStringDateUtil.
				fromStringToSqlDate(
						regDto.getDobDateText()));
		
		System.out.println("***************in service  *******"+
		regDto.getDobUtilDate());
		return loginDao.addAllUserDeatils(regDto);
	}

	@Override
	public Login addUser(Login log) {
	
		return loginDao.addUser(log);
	}

	@Override
	public ArrayList<RegisterDto> getAllUserDetails() {
		// TODO Auto-generated method stub
		return loginDao.getAllUserDetails();
	}

	@Override
	public RegisterDto getRegisterUserDetails(String un) {		
		return loginDao.getRegisterUserDetails(un);
	}

	@Override
	public void updateUserDetailsInfo(RegisterDto u) {
		// TODO Auto-generated method stub
		loginDao.updateUserDetailsInfo(u);
	}

	@Override
	public void updateUserInfo(Login lg) {
		// TODO Auto-generated method stub
	loginDao.updateUserInfo(lg);
	}

}
