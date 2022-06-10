package com.example.appthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DynamicThymeleafController {
	@GetMapping({"/","/hi"} )	
	public String hi(@RequestParam(value="name",defaultValue="Engineer",required=true)String name,Model model) { 
			model.addAttribute("name", name);
			return "dynamic";
		}

}



//@RequestMapping(value="/web",method=RequestMethod.GET)