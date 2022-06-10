package com.example.appthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafDemoController {
	@GetMapping("/hello")
	public String Hello(Model model)
	{
		model.addAttribute("name","LntEdutech");
		return "hi";
	}

}
