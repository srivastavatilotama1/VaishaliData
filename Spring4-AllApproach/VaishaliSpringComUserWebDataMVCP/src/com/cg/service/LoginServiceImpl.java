package com.cg.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;
import com.cg.dao.LoginRepository;
import com.cg.dao.RegisterDtoRepository;
import com.cg.util.MyStringDateUtil;

@Service("loginService")

@Transactional
public class LoginServiceImpl implements
ILoginService
{
	@Autowired
	LoginRepository loginJpaDao;
	
	@Autowired
	RegisterDtoRepository regJpaDao;
	

	public LoginRepository getLoginJpaDao() {
		return loginJpaDao;
	}

	public void setLoginJpaDao(LoginRepository loginJpaDao) {
		this.loginJpaDao = loginJpaDao;
	}

	public RegisterDtoRepository getRegJpaDao() {
		return regJpaDao;
	}
	public void setRegJpaDao(RegisterDtoRepository regJpaDao) {
		this.regJpaDao = regJpaDao;
	}
	@Override
	public Login getUserByUserName(String un) {
	
		return loginJpaDao.getUserByUserName(un);
	}
	
	@Override
		public RegisterDto addAllUserDeatils(RegisterDto regDto)
	{	
		String skillSetString=
				MyStringDateUtil.fromArrayToCommaSeparatedString
				(regDto.getSkillSet());
		regDto.setSkillSetStr(skillSetString);
		
		 String gender=new Character(regDto.getGender()).toString();			
		System.out.println(" in service *******"+regDto);		// 
		regJpaDao.saveAndFlush(regDto);
		RegisterDto rd=regJpaDao.getRegisterUserDetails(regDto.getUname());
		
		System.out.println(" in service  after save*******");	
		return rd;
		
		
	}
	
	@Override
	public Login addUser(Login log)
	{		
		loginJpaDao.save(log);	
		loginJpaDao.flush();
		System.out.println(" in service  after save*******");	
		return loginJpaDao.getUserByUserName(log.getUserName());
		
	}
	@Override
	public ArrayList<RegisterDto> getAllUserDetails() {
		return regJpaDao.getAllUserDetails();
	}
	@Override
	public RegisterDto getRegisterUserDetails(String un) {		
		return regJpaDao.getRegisterUserDetails(un);
	}

	@Override
	public void updateUserDetailsInfo(RegisterDto u) 
	{		
		regJpaDao.updateUserDetailsInfo(u.getLastName(),
				u.getEmail(),u.getCity(), u.getSkillSetStr(),
				u.getUname());
		}

	@Override
	public void updateUserInfo(Login lg) {
		
		loginJpaDao.updateUserInfo(lg.getPassword(),lg.getUserName());
	}
	@Override
	public boolean isValid(String un) {		
		return false;
	}

	@Override
	public boolean isUserExist(String un) {
		
		return false;
	}

}
