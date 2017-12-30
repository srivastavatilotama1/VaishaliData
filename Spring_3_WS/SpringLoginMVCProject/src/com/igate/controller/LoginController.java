package com.igate.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;


import com.igate.bean.Login;
import com.igate.service.LoginService;
import com.sun.tools.ws.processor.model.ModelVisitor;


public class LoginController  extends SimpleFormController implements Controller
{
	LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
	throws Exception 
	{
		System.out.println("formBackingObject is invoked In LoginController before referenceData Method...... ");
		Login defaultLogDetails=new Login("name****","Password*******");
		return defaultLogDetails;
	}
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception 
	{
		System.out.println("onsubmit is invoked*********************** ");
		Login log = (Login) command;
		String email = log.getUserName();
		String pwd=log.getPassword();

		System.out.println("    "+email+"*********************"+pwd);
		String msg = "Welcome : ";
		try
		{
			Login existingUser=loginService.getLogin(email);
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			if(email.equalsIgnoreCase(existingUser.getUserName())&&
					(pwd.equalsIgnoreCase(existingUser.getPassword())))
			{
				
				modelAndView.addObject("nm", email);    
				modelAndView.addObject("msg", msg);
				
			}
			return modelAndView;
		}
		catch(EmptyResultDataAccessException erdae)
		{
			return new ModelAndView("failLogin","nm",email);			
		}
		
	}

	protected Map referenceData(HttpServletRequest request) throws Exception 
	{
		System.out.println("LoginForm controller reference data******** Invoked begore submit");

		System.out.println("Before showing login form if u want to display something u can");
		//Map referenceData = new HashMap();
		//referenceData.put("courses", loginService.getLoginList());
		return null;
	}

}
