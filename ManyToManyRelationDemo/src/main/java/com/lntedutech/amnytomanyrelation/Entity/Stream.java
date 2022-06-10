package com.lntedutech.amnytomanyrelation.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Stream {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String sname;
	
	@ManyToMany(mappedBy="followedStream")
	private List<Viewer> viewers =  new ArrayList<Viewer>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stream() {
		super();
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(List<Viewer> viewers) {
		this.viewers = viewers;
	}
	
}
