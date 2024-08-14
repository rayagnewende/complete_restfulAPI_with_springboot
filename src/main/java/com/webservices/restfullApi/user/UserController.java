package com.webservices.restfullApi.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservices.restfullApi.posts.Post;

import aj.org.objectweb.asm.commons.Method;
import jakarta.validation.Valid;

@RestController
public class UserController {

//	private UserDaoService userdaoservice ;
	
	private UserRepository userRepository ; 

	public UserController(UserRepository userRepository) {
		super();
		// this.userdaoservice = userdaoservice;
		this.userRepository = userRepository ; 
	}
	


	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return userRepository.findAll(); 
	}
	 
	

	        
	@GetMapping("/users/{id}") 
	public EntityModel<User>  retrieveUser(@PathVariable int id ){
		
	Optional<User>  user = userRepository.findById(id); 
	
	   if(user.isEmpty())  throw new  UserNotFoundException("id : " + id);
		
	   EntityModel<User> entityModel = EntityModel.of(user.get()); 
	   
	  WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers()); 
	  entityModel.add(link.withRel("all-users")); 
	   
	   
	   return entityModel; 
	}
	

	@PostMapping("/users")
	public ResponseEntity<User>  createUser( @Valid @RequestBody User user) {
		
		User savedUser =  userRepository.save(user) ; 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 
		return ResponseEntity.created(location).build(); 
	}
	
	
	
	@DeleteMapping("/users/{id}")
	public void  deleteUser(@PathVariable int id) {
		
         this.userRepository.deleteById(id); 
	}
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllUPosts(@PathVariable int id){
		
		Optional<User> user = userRepository.findById(id); 
		   if(user.isEmpty())  throw new  UserNotFoundException("id : " + id);

		return user.get().getPosts(); 
		
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
