package com.meroafno.springsecurity.bonus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meroafno.springsecurity.bonus.entity.*;
import com.meroafno.springsecurity.bonus.service.*;
import com.meroafno.springsecurity.bonus.dao.*;

@Controller
@RequestMapping("/staff")
public class DemoController {
	
	@Autowired
	private StaffServices staffService;
	
	
	
	@GetMapping("/allList")
	public String getallList(Model model) {
		List<Staff> staffList=staffService.getStaffList();
		model.addAttribute("staffs",staffList);
		return "staff-list";
		
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Staff myStaff=new Staff();
		model.addAttribute("staff", myStaff);
		return "show-form";
	}
	
	@PostMapping("/saveStaff")
		public String saveStaff(@ModelAttribute("staff") Staff theStaff) {
			staffService.saveStaff(theStaff);
			return "redirect:/staff/allList";
		}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("staffId") int id, Model model) {
	
		Staff staff=staffService.getStaff(id);
		
		model.addAttribute("staff", staff);
		return "show-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("staffId") int id, Model model) {
		staffService.deleteStaff(id);
		return "redirect:/staff/allList";
	}
	
	@PostMapping("/search")
	public String searchStaff(@RequestParam("theSearchName") String theName, Model model) {
		List<Staff> staff=staffService.searchStaff(theName);
		model.addAttribute("staffs", staff);
		
		return "staff-list";
	}
	

}
