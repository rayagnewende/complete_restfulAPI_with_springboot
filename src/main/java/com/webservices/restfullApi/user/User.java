package com.webservices.restfullApi.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservices.restfullApi.posts.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")
public class User {

	@Id
	@GeneratedValue
	private Integer id ; 
	
	@Size(min=2)
	private String name ; 
	
	@Past
	private  LocalDate birthday ;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts ; 
	
	
	
	public User() {
		
	}

	public User(Integer id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
}
