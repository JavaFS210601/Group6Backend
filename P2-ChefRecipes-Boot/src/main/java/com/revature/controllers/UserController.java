package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDAO;
import com.revature.models.database.Users;
import com.revature.services.UserService;

@RestController //This annotation does everything @Controller and @ResponseBody do. Convenient!
//@Controller //indicates that the class will handle HTTP requests from DispatcherServlet
//@ResponseBody //Adds @ResponseBody to every method, which will make them all return JSON
@CrossOrigin //This acts as a CORS filter, allows all requests in if given no attributes
@RequestMapping(value="/users") //so now all requests ending in /Users will be directed here
public class UserController {

	//private UserDAO dao; //this class has an UserDAO field (so it's a dependency!)
	private UserService service;
	
	@Autowired //We want a constructor with only the UserDAO so we can use constructor injection
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(method=RequestMethod.GET) //Ensures that and GET requests to /Users uses this method
	//@ResponseBody //This will parse any Java object into JSON to send back as the response
	public List<Users> getAllUser() {
		return Arrays.asList(service.getAll()); //we're returning the array that gets returned, but as a list
	}
	
	@GetMapping("/{id}") //GetMapping will specify that GET requests with this endpoint go here
	//@PathVariable allows you to get the path variable you specified in the mapping
	//Spring has an Class called ResponseEntity that lets us set things like the status code of our response
	public ResponseEntity<Users> getOneUser(@PathVariable("id") int id) {
		
		Users a = service.getById(id);
		
		if(a==null) {
			//Returning a ResponseEntity with an empty body with a no content status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //build is for when we send nothing back
		} 
		
		//If an User is returned, sned it back in the body of the response, and 200 status code
		return ResponseEntity.status(HttpStatus.OK).body(a); //body is for when you send something back
		
	}
	
	@PutMapping //PutMapping will specify that PUT requests with this endpoint go here
												//@RequestBody turns the incoming JSON into Java
	public ResponseEntity<Users> updateUser(@RequestBody Users a){
		a = service.update(a);
		if(a==null) {
			//If an invalid User is sent, return a ResponseEntity with an empty body with a no content status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //build is for when we send nothing back
		} 
		
		//If a valid User is sent, send it back in the body of the response, and 200 status code
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a); //body is for when you send something back
	}
	
	
	
}
