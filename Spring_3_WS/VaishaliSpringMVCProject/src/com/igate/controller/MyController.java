package com.igate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//create bean at run time with id mycontroller
@Controller
public class MyController 
{
	//request comes with greet welcome.jsp should be shown.
	@RequestMapping("/greet")
	public String getPage(Model model)
	{
		model.addAttribute("message","This data sent from Controller ");
		return "welcome";
	}
	@RequestMapping("login")
	public String getLoginPage()
	{
		return "loginForm";		
	}
	
	@RequestMapping("/validate")
	public String  validateLogin(@RequestParam("uname")String username,
			@RequestParam("upass")String password)
	{
		
		if(username.equalsIgnoreCase("igate")&&
				(password.equalsIgnoreCase("igate")))
		{		
				return "successPage";
		}
		else
		{
				return "failurePage";			
		}	
	}
}
