//Author: Justin Wallace
//Date: 7/24/2021
package com.revature.models.database;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.revature.models.database.associations.RecipeIngrediants;
import com.revature.models.database.associations.RecipeSteps;

//database model for the recipes 
@Entity
@Table(name = "recipes")
public class Recipes {
	
	//primary SERIAL key referenced by recipe_id in tables recipe_ingediants and recipe_steps
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private int recipe_id;
	
	//column for recipe names
	@Column(name = "name")
	private String name;
	
	//column for description
	@Column(name = "description")
	private String description;
	
	//column for category
	@Column(name = "category")
	private String category;
	
	//column for inspiration
	@Column(name = "insiration")
	private String inspiration;
	
	//for key column referencing role_id in user_roles table
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
	@JoinColumn(name = "user_id")
	private int user_id;
	
	//list of ingrediants mapped to association table recipe_ingediants
	@OneToMany(mappedBy = "recipe", targetEntity = RecipeIngrediants.class)
	private List<RecipeIngrediants> recipeIngrediants;
	
	//list of recipe steps mapped to association table recipe_steps
	@OneToMany(mappedBy = "recipe", targetEntity = RecipeSteps.class)
	private List<RecipeSteps> recipeSteps;

	
	
	//boiler plate
	public Recipes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipes(String name, String description, String category, String inspiration,
			List<RecipeIngrediants> recipeIngrediants, List<RecipeSteps> recipeSteps) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.recipeIngrediants = recipeIngrediants;
		this.recipeSteps = recipeSteps;
	}

	@Override
	public String toString() {
		return "Recipes [recipe_id=" + recipe_id + ", name=" + name + ", description=" + description + ", category="
				+ category + ", inspiration=" + inspiration + ", recipeIngrediants=" + recipeIngrediants
				+ ", recipeSteps=" + recipeSteps + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((inspiration == null) ? 0 : inspiration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipeIngrediants == null) ? 0 : recipeIngrediants.hashCode());
		result = prime * result + ((recipeSteps == null) ? 0 : recipeSteps.hashCode());
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
		Recipes other = (Recipes) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (inspiration == null) {
			if (other.inspiration != null)
				return false;
		} else if (!inspiration.equals(other.inspiration))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeIngrediants == null) {
			if (other.recipeIngrediants != null)
				return false;
		} else if (!recipeIngrediants.equals(other.recipeIngrediants))
			return false;
		if (recipeSteps == null) {
			if (other.recipeSteps != null)
				return false;
		} else if (!recipeSteps.equals(other.recipeSteps))
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		return true;
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

	public List<RecipeIngrediants> getRecipeIngrediants() {
		return recipeIngrediants;
	}

	public void setRecipeIngrediants(List<RecipeIngrediants> recipeIngrediants) {
		this.recipeIngrediants = recipeIngrediants;
	}

	public List<RecipeSteps> getRecipeSteps() {
		return recipeSteps;
	}

	public void setRecipeSteps(List<RecipeSteps> recipeSteps) {
		this.recipeSteps = recipeSteps;
	}
	
	
}
