package com.revature.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Recipes;
import com.revature.models.database.Steps;
import com.revature.models.database.associations.RecipeIngrediants;
import com.revature.models.database.associations.RecipeSteps;
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
	
	@GetMapping(value="/search")
	public ResponseEntity<List<RecipeResponseDTO>> searchRecipes(@RequestParam(name="name" , required = false,defaultValue = "r") String name){
		List<Recipes> recipeList = service.getRecipeByName(name);
		// transfer data to a list of RecipeResonseDTO object
				List<RecipeResponseDTO> recipeDTOList = new ArrayList<RecipeResponseDTO>();
				int index = 0;
				for( Recipes recipe : recipeList  ) {
					RecipeResponseDTO recipeDTO = new RecipeResponseDTO(); 
					recipeDTO.setRecipe_id(recipe.getRecipe_id());
					recipeDTO.setCategory(recipe.getCategory());
					recipeDTO.setInspiration(recipe.getInspiration());
					recipeDTO.setName(recipe.getName());
					recipeDTO.setDescription(recipe.getDescription());
					

					// Ingrediants
					List<RecipeIngrediants> thirdTable = service.getThridTable();
					List<Ingrediants> ingrediantList = new ArrayList<Ingrediants>();
					int theID = recipe.getRecipe_id();
					for (RecipeIngrediants r :  thirdTable ) {
						if (r.getRecipe_id().getRecipe_id() == theID)  {
							ingrediantList.add(r.getIngrediant_id());
						}
						
					}
					
					// Steps
					List<RecipeSteps> thirdStepTable = service.getThridStepTable();
					List<Steps> stepList = new ArrayList<Steps>();
					for (RecipeSteps s :  thirdStepTable ) {
						if (s.getRecipe_id().getRecipe_id() == theID)  {
							stepList.add(s.getStep_id());
						}
						
					}
					recipeDTO.setIngrediants(ingrediantList);
					recipeDTO.setSteps(stepList);
						// Checking ingrediant list
					for( Ingrediants i : ingrediantList) {
						System.out.println(i.getIngrediant());
					}
					
					for( Steps s : stepList) {
						System.out.println(s.getStep_id());
					}
					
					recipeDTOList.add(recipeDTO);
					
					index++;
				}	
		return ResponseEntity.status(200).body(recipeDTOList);
	}
	
	@GetMapping
	public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes(){
		
		
		List<Recipes> recipeList = service.getAllRecipes();
		System.out.println(recipeList);
		
		// transfer data to a list of RecipeResonseDTO object
		List<RecipeResponseDTO> recipeDTOList = new ArrayList<RecipeResponseDTO>();
		int index = 0;
		for( Recipes recipe : recipeList  ) {
			RecipeResponseDTO recipeDTO = new RecipeResponseDTO(); 
			recipeDTO.setRecipe_id(recipe.getRecipe_id());
			recipeDTO.setCategory(recipe.getCategory());
			recipeDTO.setInspiration(recipe.getInspiration());
			recipeDTO.setName(recipe.getName());
			recipeDTO.setDescription(recipe.getDescription());
			

			// Ingrediants
			List<RecipeIngrediants> thirdTable = service.getThridTable();
			List<Ingrediants> ingrediantList = new ArrayList<Ingrediants>();
			int theID = recipe.getRecipe_id();
			for (RecipeIngrediants r :  thirdTable ) {
				if (r.getRecipe_id().getRecipe_id() == theID)  {
					ingrediantList.add(r.getIngrediant_id());
				}
				
			}
			
			// Steps
			List<RecipeSteps> thirdStepTable = service.getThridStepTable();
			List<Steps> stepList = new ArrayList<Steps>();
			for (RecipeSteps s :  thirdStepTable ) {
				if (s.getRecipe_id().getRecipe_id() == theID)  {
					stepList.add(s.getStep_id());
				}
				
			}
			recipeDTO.setIngrediants(ingrediantList);
			recipeDTO.setSteps(stepList);
				// Checking ingrediant list
			for( Ingrediants i : ingrediantList) {
				System.out.println(i.getIngrediant());
			}
			
			for( Steps s : stepList) {
				System.out.println(s.getStep_id());
			}
			
			recipeDTOList.add(recipeDTO);
			
			index++;
		}	
			
			
			return ResponseEntity.status(200).body(recipeDTOList);
		//return ResponseEntity.status(200).body(service.getAllRecipes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<RecipeResponseDTO>> getUsersRecipes(@PathVariable("id") int id){
		
		List<Recipes> userRecipes = service.getUserRecipes(id);
		
		// transfer data to a list of RecipeResonseDTO object
		List<RecipeResponseDTO> recipeDTOList = new ArrayList<RecipeResponseDTO>();
		int index = 0;
		for( Recipes recipe : userRecipes   ) {
			RecipeResponseDTO recipeDTO = new RecipeResponseDTO(); 
			recipeDTO.setRecipe_id(recipe.getRecipe_id());
			recipeDTO.setCategory(recipe.getCategory());
			recipeDTO.setInspiration(recipe.getInspiration());
			recipeDTO.setName(recipe.getName());
			recipeDTO.setDescription(recipe.getDescription());
			

			// Ingrediants
			List<RecipeIngrediants> thirdTable = service.getThridTable();
			List<Ingrediants> ingrediantList = new ArrayList<Ingrediants>();
			int theID = recipe.getRecipe_id();
			for (RecipeIngrediants r :  thirdTable ) {
				if (r.getRecipe_id().getRecipe_id() == theID)  {
					ingrediantList.add(r.getIngrediant_id());
				}
				
			}
			
			// Steps
			List<RecipeSteps> thirdStepTable = service.getThridStepTable();
			List<Steps> stepList = new ArrayList<Steps>();
			for (RecipeSteps s :  thirdStepTable ) {
				if (s.getRecipe_id().getRecipe_id() == theID)  {
					stepList.add(s.getStep_id());
				}
				
			}
			recipeDTO.setIngrediants(ingrediantList);
			recipeDTO.setSteps(stepList);
				// Checking ingrediant list
			for( Ingrediants i : ingrediantList) {
				System.out.println(i.getIngrediant());
			}
			
			for( Steps s : stepList) {
				System.out.println(s.getStep_id());
			}
			
			recipeDTOList.add(recipeDTO);
			
			index++;
		}	
		
		if(userRecipes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(recipeDTOList);
			
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping("/recipe/{id}")
	public ResponseEntity<RecipeResponseDTO> getRecipeById(@PathVariable("id") int id){
		
		Recipes recipe = service.getRecipeById(id);
		
		// transfer data to a RecipeResonseDTO object
		RecipeResponseDTO recipeDTO = new RecipeResponseDTO(); 
		recipeDTO.setRecipe_id(recipe.getRecipe_id());
		recipeDTO.setCategory(recipe.getCategory());
		recipeDTO.setInspiration(recipe.getInspiration());
		recipeDTO.setName(recipe.getName());
		recipeDTO.setDescription(recipe.getDescription());
		

		// Ingrediants
		List<RecipeIngrediants> thirdTable = service.getThridTable();
		List<Ingrediants> ingrediantList = new ArrayList<Ingrediants>();
		int theID = recipe.getRecipe_id();
		for (RecipeIngrediants r :  thirdTable ) {
			if (r.getRecipe_id().getRecipe_id() == theID)  {
				ingrediantList.add(r.getIngrediant_id());
			}
			
		}
		
		// Steps
		List<RecipeSteps> thirdStepTable = service.getThridStepTable();
		List<Steps> stepList = new ArrayList<Steps>();
		for (RecipeSteps s :  thirdStepTable ) {
			if (s.getRecipe_id().getRecipe_id() == theID)  {
				stepList.add(s.getStep_id());
			}
			
		}
		recipeDTO.setIngrediants(ingrediantList);
		recipeDTO.setSteps(stepList);
			// Checking ingrediant list
		for( Ingrediants i : ingrediantList) {
			System.out.println(i.getIngrediant());
		}
		
		for( Steps s : stepList) {
			System.out.println(s.getStep_id());
		}
		
		if(recipe != null) {
			return ResponseEntity.status(HttpStatus.OK).body(recipeDTO);
			
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
