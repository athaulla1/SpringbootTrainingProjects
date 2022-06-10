package com.lntedutech.onetomanyrelation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lntedutech.onetomanyrelation.entity.Department;

public interface DeptRepository extends JpaRepository<Department, Long> {
	
	
	public List<Department> findByDname(String dname);

}
