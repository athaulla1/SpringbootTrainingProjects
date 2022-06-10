package com.lntedutech.onetoonerelation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eid;
	
	private String ename;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne
	private Department dept;

	public Department getDept() {
		return dept;
	
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Employee() {
		super();
	}

	
	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
