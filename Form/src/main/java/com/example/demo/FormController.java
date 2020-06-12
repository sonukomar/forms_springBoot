package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String edureka() {
		
		return "edureka";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers) {
		
		repo.save(customers);
		return "edureka";
	}
	
	
	@RequestMapping("/getdetails")
	public String getdetails() {
		
		
		return "viewCustomers";
	}
	
		
	@PostMapping("/viewdetails")
	public ModelAndView getdetails(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("retrieve");
		Customers customer = repo.findById(id).orElse(null);
		mv.addObject(customer);
		
		return mv;
	}
}
