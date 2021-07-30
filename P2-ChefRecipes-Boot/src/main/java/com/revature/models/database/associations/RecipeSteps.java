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
	RecipeStepsKey compositeId = new RecipeStepsKey();
	
	@ManyToOne
	@MapsId("step_id")
	@JoinColumn(name = "step_id")
	private Steps step_id;
	
	@ManyToOne
	@MapsId("recipe_id")
	@JoinColumn(name = "recipe_id")
	private Recipes recipe_id;
	
	
	//boiler plate
	public RecipeSteps() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RecipeSteps(RecipeStepsKey compositeId, Steps step_id, Recipes recipe_id) {
		super();
		this.compositeId = compositeId;
		this.step_id = step_id;
		this.recipe_id = recipe_id;
	}


	@Override
	public String toString() {
		return "RecipeSteps [compositeId=" + compositeId + ", step_id=" + step_id + ", recipe_id=" + recipe_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeId == null) ? 0 : compositeId.hashCode());
		result = prime * result + ((recipe_id == null) ? 0 : recipe_id.hashCode());
		result = prime * result + ((step_id == null) ? 0 : step_id.hashCode());
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
		if (recipe_id == null) {
			if (other.recipe_id != null)
				return false;
		} else if (!recipe_id.equals(other.recipe_id))
			return false;
		if (step_id == null) {
			if (other.step_id != null)
				return false;
		} else if (!step_id.equals(other.step_id))
			return false;
		return true;
	}


	public RecipeStepsKey getCompositeId() {
		return compositeId;
	}


	public void setCompositeId(RecipeStepsKey compositeId) {
		this.compositeId = compositeId;
	}


	public Steps getStep_id() {
		return step_id;
	}


	public void setStep_id(Steps step_id) {
		this.step_id = step_id;
	}


	public Recipes getRecipe_id() {
		return recipe_id;
	}


	public void setRecipe_id(Recipes recipe_id) {
		this.recipe_id = recipe_id;
	}
	
	
	
}
