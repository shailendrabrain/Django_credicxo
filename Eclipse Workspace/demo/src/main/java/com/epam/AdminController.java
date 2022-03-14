package com.epam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Admin;
import model.Question;
import service.AdminService;
import service.QuestionService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	QuestionService questionService;

	@RequestMapping("/")
	public String home() {
		return "hello";
	}

	@RequestMapping("/adminSignup")
	public String storeAdmin(Admin admin) {
		System.out.println(admin);
		adminService.insertAdmin(admin);
		return "adminLogin";
	}

	@RequestMapping("/adminLogin")
	public ModelAndView validateAdmin(Admin admin) {
		System.out.println("to check admin   " + admin);
		String message = "invalid credential ";
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", message);
		Admin a = adminService.checkForAuthentication(admin.getEmail(), admin.getPassword());
		System.out.println("database admin  " + a);
		mv.setViewName("admin");
		if (a != null) {
			mv.setViewName("adminWelcome");
			mv.addObject("message", "login successful");
		}

		return mv;

	}


}
