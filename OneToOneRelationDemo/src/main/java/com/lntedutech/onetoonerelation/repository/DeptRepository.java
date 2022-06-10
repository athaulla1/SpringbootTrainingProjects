package com.lntedutech.onetoonerelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lntedutech.onetoonerelation.entity.Department;


public interface DeptRepository extends JpaRepository<Department, Long> {

}
