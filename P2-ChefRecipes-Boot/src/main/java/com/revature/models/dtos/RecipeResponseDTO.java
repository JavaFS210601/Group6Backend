package com.revature.models.dtos;

import java.util.Arrays;
import java.util.Objects;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Steps;

public class RecipeResponseDTO {

	
	   int recipe_id;
	   String name;
	   String description;
	   String category;
	   String inspiration;
	   String ingrediants;
	   String steps;
	   
	   
	public RecipeResponseDTO() {
		super();
		
	}


	public RecipeResponseDTO(String name, String description, String category, String inspiration,
			String ingrediants, String steps) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.ingrediants = ingrediants;
		this.steps = steps;
	}


	public RecipeResponseDTO(int recipe_id, String name, String description, String category, String inspiration,
			String ingrediants, String steps) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.ingrediants = ingrediants;
		this.steps = steps;
	}


	


	@Override
	public int hashCode() {
		return Objects.hash(category, description, ingrediants, inspiration, name, recipe_id, steps);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeResponseDTO other = (RecipeResponseDTO) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(ingrediants, other.ingrediants) && Objects.equals(inspiration, other.inspiration)
				&& Objects.equals(name, other.name) && recipe_id == other.recipe_id
				&& Objects.equals(steps, other.steps);
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


	public void setInspiration(String inspiration) {
		this.inspiration = inspiration;
	}


	public String getIngrediants() {
		return ingrediants;
	}


	public void setIngrediants(String ingrediants) {
		this.ingrediants = ingrediants;
	}


	public String getSteps() {
		return steps;
	}


	public void setSteps(String steps) {
		this.steps = steps;
	}
   
	   
}
