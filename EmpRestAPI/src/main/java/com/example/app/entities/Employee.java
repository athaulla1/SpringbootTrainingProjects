package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("EmpFilter")
public class Employee {
	
	private int empid;
	private String empname;
	private String designation;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee(int empid, String empname, String designation) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + "]";
	}
	
	
	
	
	
	
	

}
