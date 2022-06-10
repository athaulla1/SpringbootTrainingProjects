package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
	
		@GetMapping("/hi")
		public String welcomejsp()
		{
			return "home";

	}
	

}