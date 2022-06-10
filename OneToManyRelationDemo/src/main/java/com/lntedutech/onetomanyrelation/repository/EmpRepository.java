package com.lntedutech.onetomanyrelation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lntedutech.onetomanyrelation.entity.Department;
import com.lntedutech.onetomanyrelation.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{	
	
	//12 methods...Relationships.......
	//custom methods to your repository   - 3 types..........
	//findBy<<colname>>   //sorting 
	
	List<Employee> findByDeptDname(String name);     //signature.....
	
	

	
	//JPQL ---Entity
	@Query("FROM Employee WHERE dept.dname= :name")
	List<Employee> getEmployeeByDeptName(String name);
	
	
	//NativeQuery
	@Query(value="select * from Employee", nativeQuery=true)
	List<Employee> getEmployees();

	

}
