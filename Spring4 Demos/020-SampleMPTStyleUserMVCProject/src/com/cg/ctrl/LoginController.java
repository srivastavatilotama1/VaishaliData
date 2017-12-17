package com.cg.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.dto.Login;
import com.cg.service.ILoginService;

@Controller
public class LoginController 
{
	@Autowired
	ILoginService loginService;
	Login log;
	@RequestMapping(value="/showLoginPage")
	public  String displayLoginPage(Model model)
	{
		log=new Login();
		log.setUserName("CG");
		log.setPassword("CG");		
		model.addAttribute("login",log);		
		return "Login";		
	}
	
	@RequestMapping(value="/validateLoginDetails")
public String validateLoginDetails( 
		@ModelAttribute(value="login") @Valid Login lg,
		BindingResult result,Model model)
	{		
		if(result.hasErrors())
		{			
			return "Login";
		}
		
		String un=lg.getUserName();
		String pw=lg.getPassword();
		
		
		if(loginService.isUserExist(un))
		{
			if(loginService.isValid(lg))
			{
				return "SuccessLogin";	
			}
			else
			{
				return "redirect:/displayRegisterPage.obj";	
			}
		}
		else
		{
			 return "redirect:/displayRegisterPage.obj";		
		}
		
	}
}
