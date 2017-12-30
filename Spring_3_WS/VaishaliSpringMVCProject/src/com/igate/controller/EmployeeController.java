package com.igate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igate.dto.Employee;
import com.igate.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	@Qualifier("empService")

	private EmployeeService empService;
	
	@RequestMapping("/register")
	public String getRegistrationForm( Model model)
	{
		String locations[]=
			new String[]{"Pune","Mumbai","Chennai","Hyderabad","Noida"};
			
		model.addAttribute("locations",locations);
		
		String []langs=new String[]
		     {"English","Marathi","Hindi","Tamil"};
		
		model.addAttribute("langs",langs );
		
		List<String> marrStatus=new ArrayList<String>();
		marrStatus.add("Married");
		marrStatus.add("UnMarried");
		
		model.addAttribute("marrStatus",marrStatus );
		
		
		//pass blank emp object used as back beans
		Employee newEmp=new Employee();
		model.addAttribute("newEmp",newEmp);
		
		return "registerForm";
	}
	
	@RequestMapping("/saveEmp")
	public String saveEmp(@ModelAttribute("newEmp")Employee emp,Model model)
	{
		
		//empService.addEmployee(emp);
		model.addAttribute("newEmp",emp);
		return "empDetails";		
	}
}
