package com.igatepatni.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
//@RequestMapping("/welcome")
public class HelloController {
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring Security Hello World");
		return "hello";
 
	}
 
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String showAdminPage(ModelMap model) {
 
		model.addAttribute("message", "Spring Security Admin page - Welcome");
		return "adminpage";
 
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
		System.out.println("In default home redirect to Page....................");
        return "redirect:/home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String displayHomePage(ModelMap map) {
		System.out.println("In home Page....................");
        return "home";
    }

 
	
	
}