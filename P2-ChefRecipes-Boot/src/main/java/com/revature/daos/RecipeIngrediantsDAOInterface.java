package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.associations.RecipeIngrediants;

public interface RecipeIngrediantsDAOInterface extends JpaRepository<RecipeIngrediants, Integer> {

}
