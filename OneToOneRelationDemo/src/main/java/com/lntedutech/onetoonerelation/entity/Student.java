package com.lntedutech.onetoonerelation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString

@NoArgsConstructor


public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private int sid;
	
	private String sname;
	

}