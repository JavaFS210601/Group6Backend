package com.revature.models.dtos;



import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Steps;

@Entity
@Table(name = "data_transfer_table")
public class RecipeDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "recipe_id")
	private int recipeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "inspiration")
	private String inspiration;
	
	@Column(name = "user_id")
	private int userId;
	
	private String ingrediants;
	private String steps;
	public RecipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeDTO(int recipeId, String name, String description, String category, String inspiration, int userId,
			String ingrediants, String steps) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.description = description;
		this.category = category;
		this.inspiration = inspiration;
		this.userId = userId;
		this.ingrediants = ingrediants;
		this.steps = steps;
	}
	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", recipeId=" + recipeId + ", name=" + name + ", description=" + description
				+ ", category=" + category + ", inspiration=" + inspiration + ", userId=" + userId + ", ingrediants="
				+ ingrediants + ", steps=" + steps + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((ingrediants == null) ? 0 : ingrediants.hashCode());
		result = prime * result + ((inspiration == null) ? 0 : inspiration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + recipeId;
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
		result = prime * result + userId;
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
		RecipeDTO other = (RecipeDTO) obj;
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
		if (id != other.id)
			return false;
		if (ingrediants == null) {
			if (other.ingrediants != null)
				return false;
		} else if (!ingrediants.equals(other.ingrediants))
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
		if (recipeId != other.recipeId)
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
