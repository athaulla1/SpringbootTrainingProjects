package com.example.iterationthymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IterationThymeleafController 

{
	@GetMapping("/loopexample")
	public String iterationHandler(Model m)
	{
		List<String> names = List.of("Raj","Ankit","Lakshmi","Alex");
		m.addAttribute("names",names);
		return "iteration";
	}

}
