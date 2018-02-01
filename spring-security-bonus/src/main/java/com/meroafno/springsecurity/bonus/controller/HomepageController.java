package com.meroafno.springsecurity.bonus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.meroafno.springsecurity.bonus.entity.Staff;

@Controller

public class HomepageController {
	
	
	
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		Staff myStaff=new Staff();
		model.addAttribute("staff", myStaff);
		return "homepage";
		
	}

	@GetMapping("/name")
	public String getString() {
		
		return "myinfo";
	}

}
