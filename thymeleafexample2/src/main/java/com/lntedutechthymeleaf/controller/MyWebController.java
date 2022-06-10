package com.lntedutechthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyWebController {
	@RequestMapping(value="/test",method=RequestMethod.GET)
public String test()
{
	System.out.println("Testing");
	return "test";
}
} 
