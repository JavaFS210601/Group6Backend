package com.revature.models.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.database.associations.RecipeSteps;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "step_id")
@Table(name= "steps")
public class Steps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "step_id")
	private int step_id;
	
	@Column(name = "step")
	private String step;
	//
	//list of recipe steps mapped to association table recipe_steps
//	@OneToMany(mappedBy = "step", targetEntity = RecipeSteps.class)
//	private List<RecipeSteps> recipeSteps = new ArrayList();

	
	
	//boiler plate
	public Steps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Steps(String step, List<RecipeSteps> recipeSteps) {
		super();
		this.step = step;
		//this.recipeSteps = recipeSteps;
	}

	@Override
	public String toString() {
		return "Steps [step_id=" + step_id + ", step=" + step + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((recipeSteps == null) ? 0 : recipeSteps.hashCode());
		result = prime * result + ((step == null) ? 0 : step.hashCode());
		result = prime * result + step_id;
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Steps other = (Steps) obj;
//		if (recipeSteps == null) {
//			if (other.recipeSteps != null)
//				return false;
//		} else if (!recipeSteps.equals(other.recipeSteps))
//			return false;
//		if (step == null) {
//			if (other.step != null)
//				return false;
//		} else if (!step.equals(other.step))
//			return false;
//		if (step_id != other.step_id)
//			return false;
//		return true;
//	}
//
//	public String getStep() {
//		return step;
//	}

	public void setStep(String step) {
		this.step = step;
	}

//	public List<RecipeSteps> getRecipeSteps() {
//		return recipeSteps;
//	}
//
//	public void setRecipeSteps(List<RecipeSteps> recipeSteps) {
//		this.recipeSteps = recipeSteps;
//	}

	public int getStep_id() {
		return step_id;
	}

	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}
	
	
}
