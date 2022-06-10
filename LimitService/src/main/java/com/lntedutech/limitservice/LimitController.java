package com.lntedutech.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

	
	
	 @Autowired 
	 Config config;
	  
	 @GetMapping("/getlimits") 
	 public Limit retrieve() {
		 return new Limit(config.getMinimum(),config.getMaximum()); 
     }
	 
}
	
	/*
	@GetMapping("/getlimits")
	public Limit retrieve() {
		return new Limit(1, 100);
		// 
	}*/

	

