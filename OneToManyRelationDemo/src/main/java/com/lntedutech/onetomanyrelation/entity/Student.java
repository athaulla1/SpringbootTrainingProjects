package com.lntedutech.onetomanyrelation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//@Data
//@Entity
//@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private Long sid;
	
	private String sname;
	

}