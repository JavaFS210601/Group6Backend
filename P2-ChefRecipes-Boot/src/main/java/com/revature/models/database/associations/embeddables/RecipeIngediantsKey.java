//Author: Justin Wallace
//Date: 7/24/2021
package com.revature.models.database.associations.embeddables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//a class to be embedded into RecipeIngrediants class as the composite key
//represents the different parts of the composite key in recipe_ingrediants table
@Embeddable
public class RecipeIngediantsKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ingrediant_id")
	private int ingrediant_id;
	
	@Column(name = "recipe_id")
	private int recipe_id;

	
	
	//boiler plate
	public RecipeIngediantsKey() {
		super();
	}

	public RecipeIngediantsKey(int ingrediant_id, int recipe_id) {
		super();
		this.ingrediant_id = ingrediant_id;
		this.recipe_id = recipe_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingrediant_id;
		result = prime * result + recipe_id;
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
		RecipeIngediantsKey other = (RecipeIngediantsKey) obj;
		if (ingrediant_id != other.ingrediant_id)
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		return true;
	}

	public int getIngrediant_id() {
		return ingrediant_id;
	}

	public void setIngrediant_id(int ingrediant_id) {
		this.ingrediant_id = ingrediant_id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	
	
}
