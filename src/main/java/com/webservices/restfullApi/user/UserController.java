package com.webservices.restfullApi.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	private UserDaoService userdaoservice ;

	public UserController(UserDaoService userdaoservice) {
		super();
		this.userdaoservice = userdaoservice;
	}
	

	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return userdaoservice.getUsers(); 
	}
	 
	

	        
	@GetMapping("/users/{id}") 
	public User  retrieveUser(@PathVariable int id ){
		
	User  user = userdaoservice.findOne(id);
	
	   if(user == null)  throw new  UserNotFoundException("id : " + id);
		
	   return user ; 
	}



	@PostMapping("/users")
	public ResponseEntity<User>  createUser(@RequestBody User user) {
		
		User savedUser = userdaoservice.saveUser(user); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 
		return ResponseEntity.created(location).build(); 
	}
	
	/*
	@PostMapping("/hello") 
	public ResponseEntity<User> createHello(@RequestBody User user ){
	
		URI  location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id}").buildAndExpand(user.getId()).toUri(); 
		return ResponseEntity.created(location).build();
	}
	

	@PostMapping("/users") 
	public ResponseEntity<User>  createUser(@RequestBody User user ){
	
		User savedUser = userdaoservice.saveUser(user); 
		URI  location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id}").buildAndExpand(savedUser.getId()).toUri(); 
		return ResponseEntity.created(location).build(); 
	
	}   */

	

	
}
