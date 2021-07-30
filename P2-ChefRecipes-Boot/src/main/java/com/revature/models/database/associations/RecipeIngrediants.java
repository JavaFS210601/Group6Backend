package com.revature.models.database.associations;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Recipes;
import com.revature.models.database.associations.embeddables.RecipeIngediantsKey;

@Entity
@Table(name= "recipe_ingrediants")
public class RecipeIngrediants {
	
	@EmbeddedId
	RecipeIngediantsKey compositeId = new RecipeIngediantsKey();
	
	@ManyToOne
	@MapsId("ingrediant_id")
	@JoinColumn(name = "ingrediant_id")
	private Ingrediants ingrediant_id;
	
	@ManyToOne
	@MapsId("recipe_id")
	@JoinColumn(name = "recipe_id")
	private Recipes recipe_id;

	public RecipeIngrediants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeIngrediants(RecipeIngediantsKey compositeId, Ingrediants ingrediant_id, Recipes recipe_id) {
		super();
		this.compositeId = compositeId;
		this.ingrediant_id = ingrediant_id;
		this.recipe_id = recipe_id;
	}

	@Override
	public String toString() {
		return "RecipeIngrediants [compositeId=" + compositeId + ", ingrediant_id=" + ingrediant_id.getIngrediant_id() + ", recipe_id="
				+ recipe_id.getRecipe_id() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeId == null) ? 0 : compositeId.hashCode());
		result = prime * result + ((ingrediant_id == null) ? 0 : ingrediant_id.hashCode());
		result = prime * result + ((recipe_id == null) ? 0 : recipe_id.hashCode());
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
		RecipeIngrediants other = (RecipeIngrediants) obj;
		if (compositeId == null) {
			if (other.compositeId != null)
				return false;
		} else if (!compositeId.equals(other.compositeId))
			return false;
		if (ingrediant_id == null) {
			if (other.ingrediant_id != null)
				return false;
		} else if (!ingrediant_id.equals(other.ingrediant_id))
			return false;
		if (recipe_id == null) {
			if (other.recipe_id != null)
				return false;
		} else if (!recipe_id.equals(other.recipe_id))
			return false;
		return true;
	}

	public RecipeIngediantsKey getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(RecipeIngediantsKey compositeId) {
		this.compositeId = compositeId;
	}

	public Ingrediants getIngrediant_id() {
		return ingrediant_id;
	}

	public void setIngrediant_id(Ingrediants ingrediant_id) {
		this.ingrediant_id = ingrediant_id;
	}

	public Recipes getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(Recipes recipe_id) {
		this.recipe_id = recipe_id;
	}

	
	
	
}
