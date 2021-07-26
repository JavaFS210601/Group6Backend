package com.revature.models.database.associations;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.revature.models.database.Recipes;
import com.revature.models.database.Steps;
import com.revature.models.database.associations.embeddables.RecipeStepsKey;

@Entity
@Table(name= "recipe_steps")
public class RecipeSteps {

	@EmbeddedId
	RecipeStepsKey compositeId;
	
	@ManyToOne
	@MapsId("step_id")
	@JoinColumn(name = "step_id")
	private Steps step;
	
	@ManyToOne
	@MapsId("recipe_id")
	@JoinColumn(name = "recipe_id")
	private Recipes recipe;
	
	
	//boiler plate
	public RecipeSteps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeSteps(RecipeStepsKey compositeId, Steps step, Recipes recipe) {
		super();
		this.compositeId = compositeId;
		this.step = step;
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "RecipeSteps [compositeId=" + compositeId + ", step=" + step + ", recipe=" + recipe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeId == null) ? 0 : compositeId.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((step == null) ? 0 : step.hashCode());
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
		RecipeSteps other = (RecipeSteps) obj;
		if (compositeId == null) {
			if (other.compositeId != null)
				return false;
		} else if (!compositeId.equals(other.compositeId))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (step == null) {
			if (other.step != null)
				return false;
		} else if (!step.equals(other.step))
			return false;
		return true;
	}

	public RecipeStepsKey getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(RecipeStepsKey compositeId) {
		this.compositeId = compositeId;
	}

	public Steps getStep() {
		return step;
	}

	public void setStep(Steps step) {
		this.step = step;
	}

	public Recipes getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipes recipe) {
		this.recipe = recipe;
	}
	
	
}
