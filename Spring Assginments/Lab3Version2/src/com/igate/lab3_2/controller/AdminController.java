package com.igate.lab3_2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.igate.lab3_2.dao.TraineeDaoImpl;
import com.igate.lab3_2.dto.*;
import com.igate.lab3_2.exception.TraineeException;
import com.igate.lab3_2.service.TraineeServiceImpl;


@Scope("session")
@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	TraineeServiceImpl tsi;
	@Autowired
	TraineeDaoImpl tdi;
	
	public TraineeServiceImpl getTsi() {
		return tsi;
	}

	public void setTsi(TraineeServiceImpl tsi) {
		this.tsi = tsi;
	}
	
	
	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model){
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@RequestMapping(value="showSystem")
	public String validateLogin(@ModelAttribute("login") @Valid Login login,BindingResult result,Model model)
	{
		if(result.hasErrors()){
			return "login";
		}
		boolean flag=tsi.validateLogin(login);
		if (flag){
				List<TraineeDetails> list;
				list=tsi.getAllTrainees();
				model.addAttribute("traineeList", list);
				if(!(list.isEmpty()))
			return "system";
				else{
					return "error";
				}
		}
		else
			return "error";
		
	}
	
	
	@RequestMapping(value="addTrainee")
	public String addTrainee(Model model){
		model.addAttribute("trainee", new TraineeDetails());
		List<String> list=tdi.getDomain();
		model.addAttribute("domList", list);
		//for Spring form
		//not for a jsp form
		return "addtraineeSpring";
		//return addtrainee;
	}
	
	@RequestMapping(value="insertTrainee")
	//only bean in args for jsp page
	public String insertTrainee(@ModelAttribute("trainee") @Valid TraineeDetails tDetails,BindingResult result
			,Model model){
		String page="system";
		if(result.hasErrors()){
			List<String> list=tdi.getDomain();
			model.addAttribute("domList", list);
			//page="addtraineeSpring";
			return "addtraineeSpring";
		}
		boolean flag=false;
		try {
			flag = tsi.insertTrainee(tDetails);
		} catch (TraineeException e) {
			model.addAttribute("exception", e);
			return "error";
		}
		if (flag){
			List<TraineeDetails> list;
			list=tsi.getAllTrainees();
			model.addAttribute("traineeList", list);
			page="system";
			/*if(!(list.isEmpty()))
		return "system";
			else{
				return "error";
			}
		}
		else{
			return "error";
		}*/
		}
		return page;
	}
	
	
	@RequestMapping(value="removeTrainee")
	public String deleteTrainee(@RequestParam("traineeId") int traineeId,Model model){
		boolean flag=tsi.deleteTrainee(traineeId);
		if(flag){
			List<TraineeDetails> list;
			list=tsi.getAllTrainees();
			model.addAttribute("traineeList", list);
		return "system";
		}
		else
			return "error";
		
	}
	
	
	@RequestMapping(value="modifyTrainee")
	public String updateDetails(@RequestParam("traineeId") int traineeId, Model model){
		model.addAttribute("trainee", new TraineeDetails());
		model.addAttribute("traineeid", traineeId);
		List<String> dList=tdi.getDomain();
		model.addAttribute("domList", dList);
		//return "updatetrainee";
		return "updatetraineeSpring";
		
	}
	
	@RequestMapping(value="updateTrainee")
	public String updateTrainee(@ModelAttribute("trainee") @Valid 
			TraineeDetails trainee,BindingResult result,
			Model model)
	{
		System.out.println(" In controller updateTrainee function........................");
		if(result.hasErrors())
		{
			List<String> list=tdi.getDomain();
			model.addAttribute("domList", list);
			return "updatetraineeSpring";
		}
		
		boolean flag=tsi.updateTrainee(trainee);
		if(flag)
		{
			List<TraineeDetails> list;
			list=tsi.getAllTrainees();
			model.addAttribute("traineeList", list);
			if(!(list.isEmpty()))
					return "system";
			else
			{
					return "error";
			}
		}
		else
			return "error";
	}	
}
