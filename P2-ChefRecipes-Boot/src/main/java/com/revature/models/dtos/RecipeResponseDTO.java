package com.revature.models.dtos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Steps;

public class RecipeResponseDTO {

	
	   int recipe_id;
	   String name;
	   String description;
	   String category;
	   String inspiration;
//	   String ingrediants;
//	   String steps;
	   List<Ingrediants> ingrediants;
	   List<Steps> steps;
	   
	public RecipeResponseDTO() {
		super();
		
	}




	public RecipeResponseDTO(String name, String description, String category, String inspiration,
			List<Ingrediants> ingrediants, List<Steps> steps) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.ingrediants = ingrediants;
		this.steps = steps;
	}




	public RecipeResponseDTO(int recipe_id, String name, String description, String category, String inspiration,
			List<Ingrediants> ingrediants, List<Steps> steps) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.ingrediants = ingrediants;
		this.steps = steps;
	}




	public void setIngrediants(List<Ingrediants> ingrediants) {
		this.ingrediants = ingrediants;
	}




	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}




	public int getRecipe_id() {
		return recipe_id;
	}


	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getInspiration() {
		return inspiration;
	}




	public List<Ingrediants> getIngrediants() {
		return ingrediants;
	}




	public List<Steps> getSteps() {
		return steps;
	}




	public void setInspiration(String inspiration) {
		this.inspiration = inspiration;
	}



   
	   
}
