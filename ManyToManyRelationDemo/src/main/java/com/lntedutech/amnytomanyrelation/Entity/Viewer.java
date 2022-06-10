package com.lntedutech.amnytomanyrelation.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;

@Entity
public class Viewer {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String vname;

	@ManyToMany
	
	/*
	@JoinTable(
			name = "Viewer_Stream",
			joinColumns = @JoinColumn(name="viewer_id"),
			inverseJoinColumns= @JoinColumn(name="Stream_id")
			)
		*/
	private List<Stream> followedStream =  new ArrayList<Stream>();
	
    public void followStream(Stream s1)
    {
    	followedStream.add(s1);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public List<Stream> getFollowedStream() {
		return followedStream;
	}

	public void setFollowedStream(List<Stream> followedStream) {
		this.followedStream = followedStream;
	}

	public Viewer() {
		super();
	}
	
	

}
