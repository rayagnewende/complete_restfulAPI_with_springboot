package com.webservices.restfullApi.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservices.restfullApi.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer  id ; 
	
	private String description ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user  ; 
	
	public Post() {
	
	}
	

	public Post(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

}
