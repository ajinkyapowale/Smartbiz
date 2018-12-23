package com.smartbiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/admin")
public class SpController {
	
	@RequestMapping(value = "/sp")
	public String showAdminHome(ModelMap model) {
		//model.addAttribute("todos", service.retrieveTodos(getPrincipal()));
		return "spHome";
	}

}
