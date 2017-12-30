package roseindia.net.controller;

 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.springframework.ui.Model;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import roseindia.net.service.AppService;

public class MultiActionControllerExample extends MultiActionController 
{
	
	
	public ModelAndView add(HttpServletRequest request,	HttpServletResponse response) throws Exception	
	{		
		System.out.println("n multiaction controller******************************************************");
		ModelAndView modview=new ModelAndView("student/stuRegistration");
	
			return modview;
	}	
	/*public ModelAndView insert_stu(HttpServletRequest request,	HttpServletResponse response) throws Exception {
			return new ModelAndView("showmessage", "message", "Update method called");
	}*/
	/*public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			return new ModelAndView("showmessage", "message", "Edit method called");
	}
	public ModelAndView remove(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			return new ModelAndView("showmessage", "message", "Remove method called");
	}*/
}
