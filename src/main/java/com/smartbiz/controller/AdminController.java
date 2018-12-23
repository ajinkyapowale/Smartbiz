package com.smartbiz.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smartbiz.model.Vendor;
import com.smartbiz.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/")
	public String showAdminHome(ModelMap model) {
		//model.addAttribute("todos", service.retrieveTodos(getPrincipal()));
		return "adminHome";
	}
	
	@RequestMapping(value = "/vendorList")
	public ModelAndView showVendorList(ModelMap model) {
		ModelAndView modelAndView = null;
		
		try {
			List<Vendor> vendorList = adminService.getAllVendorList();
			modelAndView = new ModelAndView("vendorList");
		    modelAndView.addObject("vendors",vendorList);
		}catch (Exception e) {
			logger.error(e);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveVendor", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Vendor saveVendor(@RequestBody Vendor vendor) {
		Vendor updatedVendor = null;
		
		try {
			updatedVendor = adminService.saveVendor(vendor);
			logger.debug("Updated Vendor: "+updatedVendor);
		}catch (Exception e) {
			logger.error(e);
		}
		
		return updatedVendor;
	}
	
	@RequestMapping(value = "/deleteVendors", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public int deleteVendors(@RequestBody List<Integer> vendorIds) {
		int updatedVendorCnt = 0;
		
		try {
			updatedVendorCnt = adminService.deleteVendors(vendorIds);
			logger.debug("Updated Vendors: "+updatedVendorCnt);
		}catch (Exception e) {
			logger.error(e);
		}
		
		return updatedVendorCnt;
	}
	
	@RequestMapping(value = "/getVendor", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Vendor getVendor(@RequestBody Integer vendorId) {
		Vendor vendor = null;
		try {
			//Integer vid = Integer.parseInt(vendorId);
			vendor = adminService.getVendorById(vendorId);
			logger.debug("Vendor: "+vendor);
		}catch (Exception e) {
			logger.error(e);
		}
		
		return vendor;
	}
	

}
