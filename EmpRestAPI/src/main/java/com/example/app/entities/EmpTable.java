package com.example.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "emp_table")
//@JsonIgnoreProperties(value= {"empid", "designation"})
public class EmpTable implements Serializable {
	
	//private static final long serialVersionUID=1l;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	
	private String empname;
	
	//or use below annotations @ Entity level for multiple ignore columns
	//@JsonIgnoreProperties(value={})
	
	//Dynamic Filtering also can be done @ RestController class
	
	
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
	
	public EmpTable()
	{
		super();
	}
	public EmpTable(int empid, String empname, String designation) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "EmpTable [empid=" + empid + ", empname=" + empname + "]";
	}
	
	

}
