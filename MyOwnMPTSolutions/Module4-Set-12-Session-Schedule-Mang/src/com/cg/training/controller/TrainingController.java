package com.cg.training.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.training.dto.Training;
import com.cg.training.service.TrainingService;



@Controller
public class TrainingController {

	@Autowired
	TrainingService trainingserviceimpl;
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public ModelAndView showAll(){
		//System.out.println("hiiii");
		List<Training> mylist=trainingserviceimpl.getAllData();
		//System.out.println(mylist);
		return new ModelAndView("showall","mydata", mylist);
		
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String getData(@RequestParam("id") String id,
			Map<String,Object> model){
		
		Training tra=trainingserviceimpl.getDetailA(id);
		//System.out.println("Name is.........."+tra.gettName());
		List<String> mydep=new ArrayList<String>();
		mydep.add("ILT");
		mydep.add("VC");
		mydep.add("WBT");
		model.put("mydep", mydep);
		model.put("my",tra);
		return "register";
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String myUpdate(@Valid @ModelAttribute("my") Training tra,BindingResult result,Map<String,Object> model){
		if (result.hasErrors()) {
			List<String> mydep=new ArrayList<String>();
			mydep.add("ILT");
			mydep.add("VC");
			mydep.add("WBT");
			model.put("mydep", mydep);
			model.put("my",tra);
			return "register";
		}else{
		System.out.println("---------"+tra.gettId());
	int a=	trainingserviceimpl.updateDataFor(tra);
	//System.out.println(a);
		return "redirect:/show";
		}
	}
}
