package com.revature.models.database.associations.embeddables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//a class to be embedded into RecipeIngrediants class as the composite key
//represents the different parts of the composite key in recipe_ingrediants table
@Embeddable
public class RecipeStepsKey implements Serializable {
	
	@Column(name = "step_id")
	private int step_id;
	
	@Column(name = "recipe_id")
	private int recipe_id;

	
	//boiler plate
	public RecipeStepsKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeStepsKey(int step_id, int recipe_id) {
		super();
		this.step_id = step_id;
		this.recipe_id = recipe_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipe_id;
		result = prime * result + step_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeStepsKey other = (RecipeStepsKey) obj;
		if (recipe_id != other.recipe_id)
			return false;
		if (step_id != other.step_id)
			return false;
		return true;
	}

	public int getStep_id() {
		return step_id;
	}

	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
		
	
}