package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.database.Recipes;
import com.revature.models.dtos.RecipeDTO;
import com.revature.models.dtos.RecipeResponseDTO;
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
		
		
		List<Recipes> recipeList = service.getAllRecipes();
		System.out.println(recipeList);
		
		RecipeResponseDTO recipeDTO = new RecipeResponseDTO(); 
		int index = 0;
		for( Recipes recipe : recipeList  ) {
			recipeDTO.setRecipe_id(recipe.getRecipe_id());
			recipeDTO.setCategory(recipe.getCategory());
			recipeDTO.setInspiration(recipe.getInspiration());
			recipeDTO.setName(recipe.getName());
			recipeDTO.setDescription(recipe.getDescription());
			
			String ingrediants = "";
			for (int i = 0; i < recipe.getRecipeIngrediants().size(); i++ ) {
				ingrediants = "" + recipe.getRecipeIngrediants().get(i).getIngrediant() + " " ;
						 
						
			}
								
			String steps = "";
			for (int i = 0; i < recipe.getRecipeSteps().size(); i++ ) {
				steps = "" + recipe.getRecipeSteps().get(0).getStep().getStep() + " "; 
						
			}
			System.out.println(" ingrediant list:" + ingrediants + " steps: " + steps);
			recipeDTO.setIngrediants(ingrediants);
			recipeDTO.setSteps(steps);
			
			index++;
		}
		
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
	
	@PostMapping
	public ResponseEntity<RecipeDTO> insertRecipe(@RequestBody RecipeDTO recipeDTO){
		
		if(!service.insertRecipe(recipeDTO)) {
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.status(201).build();
	}
	
//	@PostMapping("/ingrediants/{id}")
//	public ResponseEntity<Ingrediants> insertRecipe(@RequestBody List<Ingrediants> ingrediant, @PathVariable("id") int id){
//		
//		if(!service.insertIngrediants(ingrediant, id)) {
//			return ResponseEntity.status(500).build();
//		}
//		return ResponseEntity.status(201).build();
//	}
	
	
	
}
