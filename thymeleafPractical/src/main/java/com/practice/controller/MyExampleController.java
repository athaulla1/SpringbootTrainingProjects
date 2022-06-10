package com.practice.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyExampleController {

private static final List<String> String = null;


@RequestMapping(value="/about",method=RequestMethod.GET)	
public String about(Model model)
{
	System.out.println("About handler ");
	
	model.addAttribute("name", "Dhikhi");
	model.addAttribute("currentdate",new Date(0));
	return "about";
	}	


//handling iteration
@GetMapping("/example-loop")

	public String iterateHandler(Model m) {
	//send
	
	//create a list, set collection
	
	List<String> names=List.of("Ankit","Laxmi","Karan","John");
	m.addAttribute("names",names);
	return "iterate";
	}
}

