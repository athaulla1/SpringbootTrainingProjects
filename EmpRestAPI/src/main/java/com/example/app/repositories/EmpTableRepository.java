package com.example.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.app.entities.EmpTable;

public interface EmpTableRepository extends JpaRepository<EmpTable, Integer> {
//public interface EmpTableRepository extends CrudRepository<EmpTable, Integer> {	

}
