package com.igate.trainee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.igate.trainee.beans.Login;
import com.igate.trainee.beans.Trainee;
import com.igate.trainee.exception.TraineeException;
import com.igate.trainee.service.TraineeService;

@RequestMapping(value="JSP")
@Controller
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;

	@RequestMapping(value="showLoginForm")
	public String showLoginForm(Model model) {
		Login loginBean = new Login();
		model.addAttribute("login", loginBean);
		return "loginForm";
	}
	
	@RequestMapping(value="validateUser")
	public String validateUser(@ModelAttribute("login") @Valid Login loginBean,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "loginForm";
		}
		boolean isValidUser = traineeService.validateUser(loginBean);
		if(isValidUser)
			return "pickOperation";
		else
			return "loginFail";
	}
	
	@RequestMapping(value="showAddTraineeForm")
	public String showAddTraineeForm(Model model) {
		List<String> list=traineeService.getDomain();
		model.addAttribute("list", list);
		
		Trainee trainee = new Trainee();
		model.addAttribute("trainee", trainee);
		return "addTraineeForm";
	}
	
	@RequestMapping(value = "addTrainee")
	public String addTrainee(@ModelAttribute("trainee") @Valid Trainee trainee,BindingResult result, Model model) throws TraineeException {
		boolean insert;
		if (result.hasErrors()) {
			return "addTraineeForm";
		}
		try
		{
			insert = traineeService.addTrainee(trainee);
		if(insert)
			return "pickOperation";
		else 
			throw new TraineeException("Trainee already exists");
		}catch(TraineeException te)
		{
			model.addAttribute("exception",te);
			return "error";
		}
	}
	
	@RequestMapping(value="showDeleteTraineeForm")
	public String showDeleteTraineeForm(Model model) {
		Trainee trainee = new Trainee();
		model.addAttribute("trainee", trainee);
		return "deleteTraineeForm1";
	}
	
	@RequestMapping(value="deleteTrainee")
	public String deleteTrainee(@ModelAttribute("trainee") Trainee trainee,Model model) throws TraineeException {
		boolean isValidId;
		int traineeId=trainee.getTraineeId();
		try
		{
			isValidId=traineeService.isValidTraineeId(traineeId);
			System.out.println("isValid="+isValidId);
			if(isValidId==true)
			{
				Trainee traineeBean = new Trainee();
				traineeBean = traineeService.getTraineeDetails(traineeId);
				model.addAttribute("traineeBean", traineeBean);
				return "deleteTraineeForm1";
			}
			else
			{
				throw new TraineeException("Enter a valid trainee Id");
			}
			
		}
		catch(TraineeException te)
		{
			te.printStackTrace();
			model.addAttribute("exception",te);
			return "error";
		}
		}
	
	@RequestMapping(value = "actualDeleteTrainee")
	public String actualDeleteTrainee(@RequestParam("delete") int traineeId,Model model) {
		boolean delete= traineeService.deleteTrainee(traineeId);
		if(delete) {
			return "pickOperation";
		} 
		else {
			model.addAttribute("message","error");
			return "error";
		}
		}
	
	@RequestMapping(value="showModifyTraineeForm")
	public String showModifyTraineeForm(Model model) {
		Trainee trainee = new Trainee();
		model.addAttribute("trainee", trainee);
		return "modifyTraineeForm";
	}
	
	@RequestMapping(value="modifyTrainee")
	public String modifyTrainee(@ModelAttribute("trainee") Trainee trainee,Model model) throws TraineeException {
		boolean isValidId;
		int traineeId=trainee.getTraineeId();
		try
		{
			isValidId=traineeService.isValidTraineeId(traineeId);
		if(isValidId==true)
		{
			Trainee traineeBean = new Trainee();
			traineeBean = traineeService.getTraineeDetails(traineeId);
			model.addAttribute("traineeBean", traineeBean);
			return "modifyTraineeForm";
		}
		else
		{
			throw new TraineeException("Invalid trainee id entered");
		}
		}
		catch(TraineeException te)
		{
			te.printStackTrace();
			model.addAttribute("exception",te);
			return "error";
		}
		}
	
	@RequestMapping(value = "updateTrainee")
	public String updateTrainee(@ModelAttribute("traineeBean") Trainee trainee,Model model) {
		boolean update;
			update = traineeService.updateTrainee(trainee);
		if(update) {
			return "pickOperation";
		} 
		else {
			model.addAttribute("message","error");
			return "error";
		}
	}
	
	@RequestMapping(value="showRetrieveTraineeForm")
	public String showRetrieveTraineeForm(Model model) {
		Trainee trainee = new Trainee();
		model.addAttribute("trainee", trainee);
		return "retrieveTraineeForm";
	}
	
	@RequestMapping(value="retrieveTrainee")
	public String retrieveTrainee(@ModelAttribute("trainee") Trainee trainee,Model model) throws TraineeException {
		boolean isValidId;
		int traineeId=trainee.getTraineeId();
		try
		{
			isValidId=traineeService.isValidTraineeId(traineeId);
		if(isValidId==true)
		{
			Trainee traineeBean = new Trainee();
			traineeBean = traineeService.getTraineeDetails(traineeId);
			model.addAttribute("traineeBean", traineeBean);
			return "retrieveTraineeForm";
		}
		else
		{
			throw new TraineeException("Invalid trainee id entered");
		}
		}
		catch(TraineeException te)
		{
			te.printStackTrace();
			model.addAttribute("exception",te);
			return "error";
		}
	}
	
	@RequestMapping(value ="showRetrieveAllTrainees")
	public String showRetrieveAllTrainees(Model model) throws TraineeException{
			try{
		List<Trainee> list = traineeService.getAllTrainees();
			if (list.isEmpty()) {
				String msg = "There are no Trainees";
				model.addAttribute("msg", msg);
				return "myError";
			}
			else
			{
				model.addAttribute("list", list);
				return "retrieveAllTrainees";
			}
		}catch(DataAccessException de)
		{
			de.printStackTrace();
			model.addAttribute("exception",de);
			return "error";
		}
		
	}
}

