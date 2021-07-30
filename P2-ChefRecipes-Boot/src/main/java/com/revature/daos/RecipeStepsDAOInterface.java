package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.associations.RecipeSteps;

public interface RecipeStepsDAOInterface extends JpaRepository<RecipeSteps, Integer>{

}
