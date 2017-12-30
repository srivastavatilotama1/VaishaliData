package com.igate.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igate.bean.Employee;
import com.igate.service.EmployeeServiceImpl;

@Controller

public class EmployeeController
{
	
	@Autowired
	@Qualifier("empSer")
	private EmployeeServiceImpl empService;	


	@RequestMapping("/getEmpForm")
	public String getAddEmpForm(Model model)
	{
		String locations[]=
			new String[]{"Pune","Mumbai","Chennai","Hyderabad","Noida"};

		String []langs=new String[]
		                          {"English","Marathi","Hindi","Tamil"};

		List<String> marrStatus=new ArrayList<String>();
		model.addAttribute("locations",locations);
		model.addAttribute("langs",langs );

		marrStatus.add("Married");
		marrStatus.add("UnMarried");

		model.addAttribute("marrStatus",marrStatus );

		//pass blank emp object used as back beans
		Employee newEmp=new Employee();
		//this command name is used in addemp.jsp form 
		model.addAttribute("newEmp",newEmp);

		return "AddEmployee";
	}
	


	@RequestMapping("/addEmp")
	public String addEmpDetails(Model model,@Valid @ModelAttribute("newEmp")Employee newEmp,
			BindingResult result)
	{			
		if(result.hasErrors())
		{
			String locations[]=
				new String[]{"Pune","Mumbai","Chennai","Hyderabad","Noida"};

			String []langs=new String[]
			                          {"English","Marathi","Hindi","Tamil"};

			List<String> marrStatus=new ArrayList<String>();
			model.addAttribute("locations",locations);
			model.addAttribute("langs",langs );

			marrStatus.add("Married");
			marrStatus.add("UnMarried");

			model.addAttribute("marrStatus",marrStatus );
			
			System.out.println(" In Errors ...............");
			return "AddEmployee";
		}
		else
		{
			System.out.println(" In addEmpDetails On console "+newEmp.getJoinedDate());
			System.out.println(newEmp);
			boolean flag=empService.insertEmployee(newEmp);

			if(flag==true)
			{
				System.out.println(" Data inserted..");
			}	
		}
		return "redirect:/list_emp.obj";
	}

	@RequestMapping("/list_emp")
	public ModelAndView listEmpDetails()
	{	
		System.out.println(" in List EmpDetails Methods");
		ArrayList<Employee> empList=(ArrayList)empService.getEmployeeList();
		System.out.println("............."+empList);
		ModelAndView modelview=new ModelAndView("EmployeeList");
		modelview.addObject("empList", empList);
		return modelview;		
	}


	@RequestMapping(value="/displayEditEmpJsp")
	public String displayEditEmpJsp(@RequestParam("empId") String empId,
			Model model)
	{	
		
		String locations[]=
			new String[]{"Pune","Mumbai","Chennai","Hyderabad","Noida"};

		String []langs=new String[]
		                          {"English","Marathi","Hindi","Tamil"};

		List<String> marrStatus=new ArrayList<String>();
		
		
		System.out.println(" In displayEditEmpJsp On console "+empId);
		Employee emp=empService.getEmpByEid(Integer.parseInt(empId));
		System.out.println(" in displayEditEmpJsp  "+emp);
		model.addAttribute("EmpObj",emp);

		model.addAttribute("locations",locations);
		model.addAttribute("langs",langs );
		marrStatus.add("Married");
		marrStatus.add("UnMarried");

		model.addAttribute("marrStatus",marrStatus );


		//pass blank emp object used as back beans
		Employee newEmp=new Employee();
		//this command name is used in addemp.jsp form 
		model.addAttribute("newEmp",newEmp);

		return "EditEmployee";
	}



	@RequestMapping("/editEmp")
	public String editEmpDetails(Map<String,Object> map,@ModelAttribute("newEmp")Employee newEmp,
			BindingResult result)
	{	
		System.out.println(" In Controller editEmpDetails method  On console "+newEmp);

		int noOfRec=empService.updateEmp(newEmp);

		if(noOfRec>0)
		{
			System.out.println(" Data updated.successfully.");
		}		
		return "redirect:/list_emp.obj";
	}

}
