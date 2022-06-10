package com.lntedutech.onetoonerelation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long did;
	
	private String dname;
	
    @OneToOne(mappedBy="dept")
	private Employee emp;
	
	
	public Employee getEmp() {
		return emp;
	}



	public void setEmp(Employee emp) {
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
