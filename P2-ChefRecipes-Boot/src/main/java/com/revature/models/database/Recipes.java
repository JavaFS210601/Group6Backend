//Author: Justin Wallace
//Date: 7/24/2021
package com.revature.models.database;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.database.associations.RecipeIngrediants;
import com.revature.models.database.associations.RecipeSteps;

//database model for the recipes 
@Entity
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class, 
//		property = "recipe_id")
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
	@Column(name = "inspiration")
	private String inspiration;
	
//	@Column(name = "ingrediants")
//	private String ingrediants;
//	
//	@Column(name = "steps")
//	private String steps;
	
	//for key column referencing role_id in user_roles table
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
	@JoinColumn(name = "user_id")
	private Users userId;
	
//	//list of ingrediants mapped to association table recipe_ingediants
//	@OneToMany(mappedBy = "recipe_id", targetEntity = RecipeIngrediants.class)
//	private List<RecipeIngrediants> recipeIngrediants = new ArrayList();;
//	
//	//list of recipe steps mapped to association table recipe_steps
//	@OneToMany(mappedBy = "recipe", targetEntity = RecipeSteps.class)
//	private List<RecipeSteps> recipeSteps = new ArrayList();;
	
	//boiler plate
	public Recipes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipes(String name, String description, String category, String inspiration, Users userId) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Recipes [recipe_id=" + recipe_id + ", name=" + name + ", description=" + description + ", category="
				+ category + ", inspiration=" + inspiration + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((inspiration == null) ? 0 : inspiration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + recipe_id;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (recipe_id != other.recipe_id)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
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

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
	
	
}
