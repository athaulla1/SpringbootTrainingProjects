package com.example.sbstsproj1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	

	@GetMapping("/hi")
	public String welcomejsp()
	{
		return "home";    //home.html  //home.jsp
		
		//return "Hi";
		//return "<html>........";
	}

}
