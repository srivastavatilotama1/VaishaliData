package com.igate.ctlr;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="login")
public class LoginController {
	
	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model)
	{
		//System.out.println("In prepareLogin() method");
		model.addAttribute("login",new Login());
		return "login";
	}
	
	@RequestMapping(value="checkLogin")
	public String validateCredentials(@ModelAttribute(value="login") @Valid Login login,
			BindingResult result,Model model)
	{
		//client side validation
		if(result.hasErrors())
			return "login";
		
		if(login.getUserName().equals("igate") && login.getPassword().equals("igate"))
		{
			model.addAttribute("login", login);
		    return "success";
		}
		else
			return "error";
	}
	
	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res)
	{
	    String today = new Date().toString();	
		return new ModelAndView("welcome","today",today);
	}
	

}
