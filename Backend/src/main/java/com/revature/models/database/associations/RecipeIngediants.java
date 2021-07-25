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
public class RecipeIngediants {
	
	@EmbeddedId
	RecipeIngediantsKey compositeId;
	
	@ManyToOne
	@MapsId("ingrediant_id")
	@JoinColumn(name = "ingrediant_id")
	private Ingrediants ingrediant;
	
	@ManyToOne
	@MapsId("recipe_id")
	@JoinColumn(name = "recipe_id")
	private Recipes recipe;

	
	//boiler plate
	public RecipeIngediants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeIngediants(RecipeIngediantsKey compositeId, Ingrediants ingrediant, Recipes recipe) {
		super();
		this.compositeId = compositeId;
		this.ingrediant = ingrediant;
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "RecipeIngediants [compositeId=" + compositeId + ", ingrediant=" + ingrediant + ", recipe=" + recipe
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeId == null) ? 0 : compositeId.hashCode());
		result = prime * result + ((ingrediant == null) ? 0 : ingrediant.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
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
		RecipeIngediants other = (RecipeIngediants) obj;
		if (compositeId == null) {
			if (other.compositeId != null)
				return false;
		} else if (!compositeId.equals(other.compositeId))
			return false;
		if (ingrediant == null) {
			if (other.ingrediant != null)
				return false;
		} else if (!ingrediant.equals(other.ingrediant))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}

	public RecipeIngediantsKey getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(RecipeIngediantsKey compositeId) {
		this.compositeId = compositeId;
	}

	public Ingrediants getIngrediant() {
		return ingrediant;
	}

	public void setIngrediant(Ingrediants ingrediant) {
		this.ingrediant = ingrediant;
	}

	public Recipes getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipes recipe) {
		this.recipe = recipe;
	}
	
	
}
