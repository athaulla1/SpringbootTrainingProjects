package com.example.app.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.entities.EmpTable;
import com.example.app.entities.Employee;
import com.example.app.repositories.EmpTableRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;



@RestController
public class EmpRestController {
	
	
	private static final Logger logobj = LoggerFactory.getLogger(EmpRestController.class);
	
	@Autowired 
	EmpTableRepository repo;

	
	@GetMapping("/emphi")
	public String displaytext()
	{
		return "Welcome to RestAPI world";
	}
	
	
	@GetMapping("/emp")
	public MappingJacksonValue  display()
	{
		
		Employee emp = new Employee();
		
		emp.setEmpid(1001);
		
		emp.setEmpname("Athaulla");
		emp.setDesignation("Corporate Trainer");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("empid","empname");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("EmpFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(emp);
		mapping.setFilters(filters);
		
		
        logobj.info("Info Log data from display method");			
		return mapping;
		
	}

	
	
	@RequestMapping(value="/empall",method=RequestMethod.GET)
	//@GetMapping("/empall")
	public List<EmpTable> displayall()
	{
		logobj.warn("Warning Log data from emp all method");
		return repo.findAll();
	}
	
	
	@GetMapping("/emphateoas/{id}")
	public EntityModel<EmpTable> displayh(@PathVariable("id") int id)
	{
		
		//Optional<EmpTable> emp = repo.findById(id);
		EmpTable emp = repo.findById(id).get();
		
		EntityModel<EmpTable> resource = EntityModel.of(emp);
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).displayall())
				.withRel("DisplayAllEmp"));
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).display())
				.withRel("DisplayNormalEmp"));
		
		return resource;
		
	}
	
	
	@GetMapping("/emp/{id}")
	@Cacheable("Emp-cache")
	@Transactional(readOnly=true)
	public ResponseEntity<Optional<EmpTable>> display(@PathVariable("id") int id)
	{
		Optional<EmpTable> emp = repo.findById(id);
		
		if (emp.isEmpty())
		{
			logobj.error("Error from Emp ID method");
			System.out.println(emp+"Record Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(emp+"Record Found");
		
		
		logobj.info("Info Log data from Emp ID Method");
		return ResponseEntity.of(Optional.of(emp));
		
	}
	
	
	@PostMapping("/addemp")
	public EmpTable addemp(@RequestBody EmpTable emp)
	{
		return repo.save(emp);
		
	}
	
	
	
	@PutMapping("/updateemp")
	public EmpTable updateemp(@RequestBody EmpTable emp)
	{
		return repo.save(emp);
		
	}
	
	//Evict Cache LRU RANDOM      - LFU -Least Recently Used Lease Frequently Used
	
	@DeleteMapping("/deleteemp/{id}")       
	@CacheEvict("Emp-cache")
	public ResponseEntity<Void> delete(@PathVariable("id") int id)
	{
		try
		{
			
		
		repo.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
	
		

}
