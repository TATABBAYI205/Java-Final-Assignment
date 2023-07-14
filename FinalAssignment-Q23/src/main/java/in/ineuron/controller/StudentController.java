package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

/*
 23. Create a Spring MVC application that allows users to register and login. The
	 application should have a registration form that accepts user details and a login form
	 that authenticates users.
 */

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping
	public String landingPage() {
		return "index";
	}
	@GetMapping(value = "/showlogin")
	public String showLoginPage() {
		return "login";
	}
	@GetMapping(value = "/register")
	public String showHome() {
		return "register";
	}
	
	@PostMapping("/register")
	public String saveCustomer(Model model, @ModelAttribute("std") Student student) {
		System.out.println(student);
		String status = service.registerStudent(student);
		model.addAttribute("status", status);
		
		return "registerSuccess";
	}
	
	@GetMapping("/login")
	public String loginCustomer(Model model, @RequestParam Integer sid, @RequestParam String password) {
		System.out.println(sid);
		System.out.println(password);
		String loginStatus = service.loginStudent(sid, password);
		System.out.println("Login Status :: "+loginStatus);
		model.addAttribute("loginStatus", loginStatus);
		return "loginSuccess";
	}
	
}
