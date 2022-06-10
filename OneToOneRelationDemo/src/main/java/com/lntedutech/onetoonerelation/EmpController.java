package com.lntedutech.onetoonerelation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lntedutech.onetoonerelation.entity.Department;
import com.lntedutech.onetoonerelation.entity.Employee;
import com.lntedutech.onetoonerelation.entity.Student;
import com.lntedutech.onetoonerelation.repository.DeptRepository;
import com.lntedutech.onetoonerelation.repository.EmpRepository;
import com.lntedutech.onetoonerelation.EmpRequest;

@RestController
public class EmpController {
	
	
	@Autowired 
	EmpRepository erepo;
	
	@Autowired 
	DeptRepository drepo;



	@PostMapping("/addempdept")
	public ResponseEntity<Employee> addempdept(@RequestBody EmpRequest ereq)
	{
		Department dept = new Department();
		
		dept.setDname(ereq.getDeptname());
	
		//dept = drepo.save(dept);
		
		Student stud =  new Student();
		
		
		Employee emp = new Employee();
		emp.setEname(ereq.getEmpname());
		emp.setDept(dept);
		
		emp = erepo.save(emp);
		
		
		//Cascading...
		
		
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
		}
	
	
	
	@GetMapping("/employee/dept/{dname}")
	public ResponseEntity<List<Employee>> getEmployeByDepartment(@PathVariable String dname)
	{
		
		return new ResponseEntity <List<Employee>> (erepo.getEmployeeByDeptName(dname), HttpStatus.OK);
		
		//return new ResponseEntity <List<Employee>> (erepo.findByDeptDname(dname), HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		
	    return erepo.getEmployees();
	
		//return new ResponseEntity <List<Employee>> (erepo.findByDeptDname(dname), HttpStatus.OK);
	}
	

	
	@GetMapping("/departments")
	public List<DepartmentResponse> getDepartments()
	{
		List<Department> depts = drepo.findAll();
		
		
		List<DepartmentResponse> dresps = new ArrayList<>();
		
		depts.forEach(dept ->
		{
			DepartmentResponse dresp = new DepartmentResponse();
			
			dresp.setDname(dept.getDname());
			dresp.setId(dept.getDid());
			dresp.setEname(dept.getEmp().getEname());
			dresps.add(dresp);
			
		});
		
		return dresps;
		
	}
	
	
	
	
	@DeleteMapping("/deleteemp/{id}")       
	public ResponseEntity<Void> delete(@PathVariable("id") Long id)
	{
		try
		{
		erepo.deleteById(id);
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
	


	
