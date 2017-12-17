package com.cg.ctrl;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("myCtrl")
public class HelloController 
{
	
	@RequestMapping(value="/hello",
			method=RequestMethod.GET)
	public ModelAndView sayMsg()
	{
		String td=LocalDate.now().toString();
		return new ModelAndView("Hello","today",td);
	}

}
