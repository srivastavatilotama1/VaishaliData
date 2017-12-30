package com.igatepatni.rest.controller;

import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.igatepatni.rest.domain.Employee;
import com.igatepatni.rest.domain.EmployeeDS;
import com.igatepatni.rest.domain.EmployeeList;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeDS employeeDS;

	public void setEmployeeDS(EmployeeDS ds) {
		this.employeeDS = ds;
	}

	private static final String VIEW_NAME = "employees";

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute(new Employee());
		return "updatepage";
	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String addEmp(Model model) {
		model.addAttribute(new Employee());
		return "addpage";
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public String deleteEmp(Model model) {
		model.addAttribute(new Employee());
		return "deletepage";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getEmployee(@PathVariable String id) {
		System.out.println("in get in jsp response " + id);
		Employee e = employeeDS.getEmployee(Integer.parseInt(id));
		return new ModelAndView("getpage", "employee", e);
	}

	/*@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public String getEmployeeforClient(@PathVariable String id) {
		System.out.println("in get  using json response " + id);
		Employee e = employeeDS.getEmployee(Integer.parseInt(id));
		return e.toString();
	}
*/
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public String updateEmployee(@ModelAttribute Employee employee) {
		System.out.println("in updateEmp() " + employee);
		employeeDS.update(employee);
		return "resultpage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		System.out.println("in add emp : " + employee);
		employeeDS.add(employee);
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView("employees", "employees", list);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ModelAndView removeEmployee(@PathVariable String id,@ModelAttribute Employee employee) {
		System.out.println("in delete " + id);
		System.out.println("in delete1 " + employee.getId());
		employeeDS.remove(employee.getId());
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView(VIEW_NAME, "employees", list);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView("employees", "employees", list);
	}
	
	
	

}
