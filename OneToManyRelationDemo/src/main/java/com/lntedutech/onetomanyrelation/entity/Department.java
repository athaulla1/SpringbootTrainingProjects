package com.lntedutech.onetomanyrelation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long did;
	
	private String dname;
	
	
	@OneToMany(mappedBy="dept")
	private List<Employee> emp = new ArrayList<>();
	
	public List<Employee> getEmp() {
		return emp;
	}



	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}



	public Department() {
		super();
	}

	public String getDname() {
		return dname;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
}
