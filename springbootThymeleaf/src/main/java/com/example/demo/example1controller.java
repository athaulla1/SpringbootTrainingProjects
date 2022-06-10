package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class example1controller {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message","Spring Boot Thymeleaf");
		return "index";
	}

}
