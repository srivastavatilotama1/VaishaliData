package com.cg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cg.entities.Participants;
import com.cg.entities.Workshop;
import com.cg.service.IParticipantService;
import com.cg.service.IWorkshopService;

@Controller
@SessionAttributes("WID")

public class WorkshopController 
{
	@Autowired
	private IParticipantService participantsService;
	@Autowired
	private IWorkshopService workshopService;
	
	
	@RequestMapping("/home")
	public String getHomePage(Model model)
	{
		model.addAttribute("workshopList",workshopService.getAllScheduledWS());	
		model.addAttribute("workshop",new Workshop());
		return "Home";
	}
	
	@RequestMapping(value="/RegistrationSuccess",method=RequestMethod.GET)
	public String registerParticipant(
			@ModelAttribute("participantModel") @Valid Participants part, 
			BindingResult result,
			Model model,HttpServletRequest req)
	{
		if(result.hasErrors())
		{			
			return "WSRegPage";
		}
		HttpSession ses=req.getSession();
		long wwid=(long)ses.getAttribute("WID");
		System.out.println(" Session Data Is..................."+wwid);
		part.setWid(wwid);
		Participants participant=  participantsService.addParticipants(part);
		System.out.println("Data Added ............................."+
		participant);
		//model.addAttribute("participantModel", new Participants());
		model.addAttribute("message",
				"Your Registration Id Is:"+participant.getRegistrationId());
		
		return "RegistrationSuccess";
	}
	
	@RequestMapping(value="/findAvailableWS",method=RequestMethod.GET)
	public String showRegPage(@RequestParam("wid") long workshopId,Model model)
	{
		long count =  participantsService.getNoOfParticipantCount(workshopId);
		if(count>=5)
		{
			return "FailurePage";
		
		}
		else
		{
			System.out.println("  Id is ********************************"+workshopId);
			model.addAttribute("participantModel", new Participants());
			model.addAttribute("WID", workshopId);
			return "WSRegPage";
		}
	}

}
