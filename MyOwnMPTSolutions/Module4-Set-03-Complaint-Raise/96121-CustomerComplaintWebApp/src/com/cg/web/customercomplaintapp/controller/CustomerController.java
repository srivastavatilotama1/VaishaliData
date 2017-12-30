
/********************************************************************************
 * File					:CustomerController.java
 * Author Name			:96121
 * Description			:Controller class to receive all the requests and handle it
 * 						 by calling service methods and provide the next view
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************/

package com.cg.web.customercomplaintapp.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.web.customercomplaintapp.entities.Complaint;
import com.cg.web.customercomplaintapp.exception.CustomerComplaintException;
import com.cg.web.customercomplaintapp.service.ICustomerService;

@Controller
public class CustomerController
{
	@Autowired
	ICustomerService iCustomerService;
	
	/*
	 * The method getCustomerComplaintFormPage populates a list of categories
	 * The method adds the populated list into Model object
	 * The method also adds a Complaint bean object into Model object
	 * The method returns view "RaiseComplaintPage"
	 */
	
	@RequestMapping("customerComplaintForm")
	public String getCustomerComplaintFormPage(Model model)
	{
		ArrayList<String> categories=new ArrayList<String>();
		categories.add("Internet Banking");
		categories.add("General Banking");
		categories.add("Others");
		model.addAttribute("categories",categories);
		model.addAttribute("complaint",new Complaint());
		return "RaiseComplaintPage";
	}
	
	/*
	 * The method addCustomerComplaint validates the values entered by user in RaiseComplaintPage.jsp
	 * If the values are invalid the method populates a list of categories and return view "RaiseComplaintPage"
	 * If values are valid the method calls the addCustomerComplaint method of ICustomerService interface
	 * to insert the data into database
	 * If data is not inserted due to some exception the method returns view "Error" with proper message
	 * If data is inserted the method returns view "Success"
	 */
	
	@RequestMapping(value="addCustomerComplaint",method=RequestMethod.GET)
	public ModelAndView addCustomerComplaint(@ModelAttribute("complaint") 
					@Valid Complaint complaint,
					BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			ArrayList<String> categories=new ArrayList<String>();
			categories.add("Internet Banking");
			categories.add("General Banking");
			categories.add("Others");
			model.addAttribute("categories",categories);
			return new ModelAndView("RaiseComplaintPage");
			
		}
		else
		{
			String category=complaint.getCategory();
			if(category.equals("Internet Banking"))
			{
				complaint.setPriority("High");
			}
			else if(category.equals("General Banking"))
			{
				complaint.setPriority("Medium");
			}
			else if(category.equals("Others"))
			{
				complaint.setPriority("Low");
			}
			complaint.setStatus("Open");
			try
			{
				int complaintId=iCustomerService.addCustomerComplaint(complaint);
				System.out.println(complaintId);
				model.addAttribute("complaintId",complaintId);
				return new ModelAndView("Success");
			}
			catch(CustomerComplaintException e)
			{
				model.addAttribute("error",e.getMessage());
				return new ModelAndView("Error");
			}
		}
	}
	
	
	/*
	 * The method getCheckStatusFormPage returns view "CheckStatus"
	 */
	@RequestMapping("checkStatusForm")
	public String getCheckStatusFormPage()
	{
		return "CheckStatus";
	}
	
	
	/*
	 * The method processCheckStatus gets complaintId from CheckStatus view and calls 
	 * getStatus method of ICustomerService to find and retrieve record and return view "CheckStatus"
	 * If complaintId entered is not present proper message is displayed
	 * If any exception occurs proper message is displayed on Error page 
	 */
	
	@RequestMapping(value="processCheckStatusForm",method=RequestMethod.GET)
	public ModelAndView processCheckStatus(@RequestParam("complaintId")
	int complaintId,Model model)
	{
		try
		{
			Complaint complaint=iCustomerService.getStatus(complaintId);
			if(complaint==null)
			{
				model.addAttribute("message","Complaint Id entered is incorrect");
				return new ModelAndView("CheckStatus");
			}
			else
			{
				model.addAttribute("complaint",complaint);
				return new ModelAndView("CheckStatus");
			}
		}
		catch(CustomerComplaintException e)
		{
			model.addAttribute("error",e.getMessage());
			return new ModelAndView("Error");
		}
	}
}
