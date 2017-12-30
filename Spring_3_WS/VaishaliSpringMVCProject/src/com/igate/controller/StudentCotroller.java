package com.igate.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igate.dto.Student;

@Controller
public class StudentCotroller
{

	@RequestMapping("enroll")
	public String getEnrollForm(Model model)
	{
		model.addAttribute("stud",new Student());
		return "enroll";
		
	}
	@RequestMapping("saveStudent")
	public String saveStudent(@Valid @ModelAttribute("stud")Student student,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return "enroll";
		}
		return "successStudent";
		
	}
}
