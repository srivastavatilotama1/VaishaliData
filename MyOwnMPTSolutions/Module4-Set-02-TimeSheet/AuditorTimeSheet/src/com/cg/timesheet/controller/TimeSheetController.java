package com.cg.timesheet.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.timesheet.bean.TimeSheetBean;
import com.cg.timesheet.bean.WorkAction;
import com.cg.timesheet.exception.TimeSheetException;
import com.cg.timesheet.service.ITimeSheetService;

@Controller
public class TimeSheetController {

	@Autowired
	private ITimeSheetService service;

	public ITimeSheetService getService() {
		return service;
	}

	public void setService(ITimeSheetService service) {
		this.service = service;
	}

	@RequestMapping("/showHomePage.obj")
	public String doShowHomePage() {
		return "index";
	}

	@RequestMapping("/enterTimeSheet.obj")
	public ModelAndView doEnterTimeSheet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("timeSheetEntry");
		mv.addObject("workActions", WorkAction.values());
		TimeSheetBean tsb = new TimeSheetBean();
		tsb.setTimeSheetDate(LocalDate.now());
		mv.addObject("timeSheet", tsb);
		return mv;
	}

	@RequestMapping("/addTimeSheet.obj")
	public ModelAndView doaddTimeSheet(
			@ModelAttribute("timeSheet") @Valid TimeSheetBean timeSheet,
			BindingResult results) {
		ModelAndView mv = new ModelAndView();

		if (results.hasErrors()) {
			mv.setViewName("timeSheetEntry");
			mv.addObject("workActions", WorkAction.values());
			mv.addObject("timeSheet", timeSheet);
		} else {
			try {
				int id = service.addTiemSheet(timeSheet);
				mv.setViewName("timeSheetAdded");
				mv.addObject("info", "TimeSheet is recorded with id: " + id);
			} catch (TimeSheetException exp) {
				mv.setViewName("error");
				mv.addObject("err", exp.getMessage());
			}
		}

		return mv;
	}

	@RequestMapping("/listTimeSheets.obj")
	public ModelAndView doListTimeSheets(@RequestParam("empId") String empId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("timeSheetsList");

		if (empId != null && !empId.startsWith("-1")) {

			try {
				List<TimeSheetBean> timeSheets = service
						.getRelatedTimeSheets(empId);
				mv.addObject("timeSheets", timeSheets);
			} catch (TimeSheetException exp) {
				mv.setViewName("error");
				mv.addObject("err", exp.getMessage());
			}
		}
		return mv;
	}
}
