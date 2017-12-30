package com.igate.ctlr;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value="/showForm")
	public String showForm(Model model)
	{
	  model.addAttribute("login", new Login());
	  return "login";
	}
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin()
	{
	  	
	  return "success";	
	}

}
