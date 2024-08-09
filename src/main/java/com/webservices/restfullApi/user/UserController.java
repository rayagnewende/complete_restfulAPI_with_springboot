package com.webservices.restfullApi.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public ResponseEntity<User>  createUser( @Valid @RequestBody User user) {
		
		User savedUser = userdaoservice.saveUser(user); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 
		return ResponseEntity.created(location).build(); 
	}
	
	
	
	@DeleteMapping("/users/{id}")
	public void  deleteUser(@PathVariable int id) {
		
         this.userdaoservice.deleteById(id); 
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
