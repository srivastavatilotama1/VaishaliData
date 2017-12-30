package com.cg.skyStar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.skyStar.bean.SkyStar;
import com.cg.skyStar.service.ISkyService;

@Controller
public class SkyController {

	@Autowired
	ISkyService service;

	@RequestMapping("/showHomePage")
	public ModelAndView showProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/custReport")
	public ModelAndView showProducts() {
		ModelAndView mv = new ModelAndView();

		List<SkyStar> SkyStar = service.getAll();
		if (SkyStar.isEmpty()) {
			mv.setViewName("error");
			mv.addObject("msg","The Customer List is Empty, Either you didn't write commit or table does not exist");
		} else {
			mv.setViewName("custReport");
			mv.addObject("list", SkyStar);
		}

		return mv;

	}

	@RequestMapping("/getCustomerDescription")
	public ModelAndView getProductDescription(@RequestParam("id") String custNum) {
		ModelAndView mv = new ModelAndView();

		SkyStar skyStar = service.getDetail(custNum);
		if (skyStar == null) {
			mv.setViewName("error");
			mv.addObject("msg","The Customer does not exist");
		} else {
			mv.setViewName("custDetail");
			mv.addObject("skyStar", skyStar);
		}

		return mv;

	}
}
