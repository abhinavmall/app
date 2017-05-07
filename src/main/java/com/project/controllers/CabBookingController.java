package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dto.Customer;
import com.project.dto.Driver;
import com.project.services.DriverService;
import com.project.services.OrderService;

@Controller
public class CabBookingController {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("driverList", driverService.getAllDrivers());
		model.addAttribute("customer", new Customer());
		return "welcome";
	}
	
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public String bookCab(@ModelAttribute("customer") Customer customer){
		Driver driver = this.driverService.getNearestAvailableDriver(customer);
		this.orderService.bookCab(customer, driver);
		return "redirect:/";
	}
}
