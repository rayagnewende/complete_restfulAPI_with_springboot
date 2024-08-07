package com.webservices.restfullApi.user;

import java.time.LocalDate;

public class User {

	private Integer id ; 
	private String name ; 
	private  LocalDate birthday ;
	
	
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
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
}
