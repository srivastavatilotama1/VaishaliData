package com.cg.elms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.elms.entities.EmployeeDetails;
import com.cg.elms.entities.EmployeeLeaveDetails;
import com.cg.elms.service.ILmsService;

@Controller
public class LMSController {

	@Autowired
	ILmsService service;

	// private EmployeeDetails emp = new EmployeeDetails();

	@RequestMapping("/viewHistory.obj")
	public String viewForm(Model model) {
		model.addAttribute("emp", new EmployeeDetails());
		return "Home";
	}

	@RequestMapping(value = "/viewHistory.obj", method = RequestMethod.POST)
	public String getLeaveDetails(
			@ModelAttribute("emp") @Valid EmployeeDetails emp,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Home";
		} else {
			emp = service.getEmployeeDetails(emp.getEmpId());
			if (emp != null) {
				model.addAttribute("empName", emp.getEmpName());
				model.addAttribute("empId", emp.getEmpId());
				List<EmployeeLeaveDetails> leaves = service.getLeaveDetails(emp
						.getEmpId());
				if (leaves.isEmpty()) {
					model.addAttribute("message", "No Leaves Record Found");
				} else {
					model.addAttribute("leaves", leaves);
				}
				return "ViewLeaveDetails";
			} else {
				model.addAttribute("message", "This Employee Id doesn't exist");
				return "Home";
			}
		}
	}

}
