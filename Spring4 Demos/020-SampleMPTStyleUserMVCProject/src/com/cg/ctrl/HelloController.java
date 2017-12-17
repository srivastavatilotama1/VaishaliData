package com.cg.ctrl;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("myCtrl")
public class HelloController  
{
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView sayMsg()
	{
		String today=new Date().toString();
		return new ModelAndView("Hello","today",today);
		
	}
	
	@RequestMapping("/showWelcome")
	public ModelAndView displayWelcomePage()
	{
		String today=new Date().toString();
		return new ModelAndView("Welcome","today",today);
		
	}
	

}
