package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.database.Recipes;
import com.revature.services.RecipeService;

@RestController
@CrossOrigin
@RequestMapping(value="/recipes")
public class RecipeController {
	
	private RecipeService service;
	
	@Autowired
	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Recipes>> getAllRecipes(){
		return ResponseEntity.status(200).body(service.getAllRecipes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Recipes>> getUsersRecipes(@PathVariable("id") int id){
		
		List<Recipes> userRecipes = service.getUserRecipes(id);
		
		
		if(userRecipes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userRecipes);
			
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	
	
}
