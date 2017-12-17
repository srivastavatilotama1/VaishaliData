package com.igate.ctlr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igate.jdbc.bean.Application;
import com.igate.jdbc.dao.IApplicationDAO;
import com.igate.jdbc.service.IApplicationService;
@Scope("session")
@Controller
@RequestMapping("applications")
public class ApplicationController
{	
	ArrayList<String> cityList;
	ArrayList<String> termList;
	
	@Autowired
	IApplicationService service;	
	
	@RequestMapping(value="/showCreaditApplication")
	public String prepareApplication(Model model)
	{
		System.out.println(" In prepareApplication ***********************************");
		cityList =new ArrayList<String>();
		
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Delhi");
		
		termList =new ArrayList<String>();		
		termList.add(" I Agree To Terms and Conditions");
		
		
		model.addAttribute("cityList",cityList);
		model.addAttribute("skillList",termList);
		
		model.addAttribute("app",new Application());
	    return "CreaditCardApp";	
	}
	
	@RequestMapping(value="/insertApplication")
	public String insertApplication
	(@ModelAttribute("app")@Valid Application application,
			BindingResult result,Model model)
	{
		System.out.println(" In insertApplication **********************************");
		 if(result.hasErrors())
		 {
			 model.addAttribute("cityList",cityList);
    		 model.addAttribute("skillList",termList);

			 return "CreaditCardApp";
		 }
		 
		  int insertSuccess=service.insertApplication(application);
		  
		  
		  if(insertSuccess!=0)
		  {
             model.addAttribute("app",application);  		  
	  	     return "InsertSuccess";
		  }
		  else
			 return "InsertFail";
	}
	
	
	@RequestMapping(value="/list_applications")
	public  ModelAndView showAllApplications(ModelAndView model)throws IOException
	{			
		    ArrayList<Application> listApplication = (ArrayList<Application>) 
		    		service.getAllApplicationDetails();
		    model.addObject("listApp", listApplication);
		    model.setViewName("DisplayAllApplications");		 
		    return model;
	
	}
	
	
	@RequestMapping(value="/displayEditApplicationJsp", method=RequestMethod.GET)
	public String displayEditAppJsp(@RequestParam("appId") String appId,
			Model model)
	{			
		Application application=service.getAppByAppId(Integer.parseInt(appId));
		System.out.println(" in displayEditAppJsp  "+application);
		model.addAttribute("AppObj",application);
		Application newApp=new Application();
		model.addAttribute("newApp",newApp);
		return "EditApplication";
	}
	
	@RequestMapping(value="/editApp", method=RequestMethod.POST)
	public String editApplicationDetails(Map<String,Object> map,
			@ModelAttribute("newApp")Application newApp,
			BindingResult result)
	{	
		System.out.println(" In Controller editEmpDetails method  On console "+newApp);

		int noOfRec=service.updateApp(newApp);

		if(noOfRec>0)
		{
			System.out.println(" Data updated.successfully.");
		}		
		return "redirect:/applications/list_applications.obj";
	}
	
	
	


}
