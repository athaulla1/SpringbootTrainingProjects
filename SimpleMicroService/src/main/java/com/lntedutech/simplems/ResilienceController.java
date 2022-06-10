package com.lntedutech.simplems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ResilienceController {
	
	private Logger logger = LoggerFactory.getLogger(ResilienceController.class);
	
	@GetMapping("/simpleapi")
	@RateLimiter(name = "simpleapi")
	@CircuitBreaker(name="simpleapi",fallbackMethod="fallbackresponse")
	public String simpleApi()
	{
		
		////@Retry(name="simpleapi",fallbackMethod="fallbackresponse")
		logger.info("Simple API Called");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy",String.class);
		return forEntity.getBody();
		
	}
	
	public String fallbackresponse(Exception e)
	{
		
		
		logger.info("Response coming from fallback");
		return "fallback response";
	}
	
	
	

}
