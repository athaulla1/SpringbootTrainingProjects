package com.lntedutech.onetoonerelation;


public class DepartmentResponse {
	
	
	private Long id;
	
	private String dname;
	
	private String ename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public DepartmentResponse() {
		super();
	}
	

}
