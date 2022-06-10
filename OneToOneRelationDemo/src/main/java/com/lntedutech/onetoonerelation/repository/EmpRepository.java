package com.lntedutech.onetoonerelation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lntedutech.onetoonerelation.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{	
	
	List<Employee> findByDeptDname(String name);
	
	@Query("FROM Employee WHERE dept.dname= :name")
	List<Employee> getEmployeeByDeptName(String name);
	
	@Query(value="select * from Employee", nativeQuery=true)
	List<Employee> getEmployees();

	

}
