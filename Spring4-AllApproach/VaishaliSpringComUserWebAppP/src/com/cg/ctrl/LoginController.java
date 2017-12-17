package com.cg.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.bean.Login;
import com.cg.service.ILoginService;

@Controller
@RequestMapping("loginCtrl")
public class LoginController 
{
	@Autowired
	ILoginService loginService;
	@RequestMapping(value="/showLoginPage")
	public  String displyLoginPage(Model model)
	{
		Login lg=new Login();
		
		model.addAttribute("login",lg);
		return "Login";
	}
	
	@RequestMapping(value="/validateLoginDetails")
	public String validateUserDetails(
		@ModelAttribute(value="login")
		@Valid Login lgg,
		BindingResult result,
		Model model)
	{
		
		if(result.hasErrors())
		{
			return "Login";
		}
		
		String un=lgg.getUserName();
		String pw=lgg.getPassword();
		
		Login existingUserObj=loginService.
				getUserByUserName(un);
		System.out.println(" in login ctrl user exist : "+
				existingUserObj);
		
		
		if(existingUserObj==null)
		{
			//model.addAttribute("MsgObj","User Does not Exist");
			//return "Register";
			return "redirect:/displayRegisterPage.obj";
			
		}
		else
		{
			if(un.equalsIgnoreCase(existingUserObj.getUserName())
				&&
				(pw.equalsIgnoreCase(existingUserObj.getPassword())))
			{
				model.addAttribute("UserObj", un);
				return "Success";
			}
			else
			{
				model.addAttribute("MsgObj","Enter  Correct Password");
		     	return "Login";
			}
		}
		
	}

}
