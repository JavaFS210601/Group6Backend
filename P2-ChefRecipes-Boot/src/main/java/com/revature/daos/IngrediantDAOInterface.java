package com.revature.daos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.database.Ingrediants;

public interface IngrediantDAOInterface extends JpaRepository<Ingrediants, Integer> {
	
	@Transactional
	@Modifying
	@Query("Update Ingrediants SET ingrediant = ?1, ammount = ?2"
			+ " WHERE ingrediant_id = ?3")
	void updateIngrediants(String ingrediant, 
			String ammount, 
			int ingrediant_id);

	
	
//	@Transactional
//	//@Modifying(flushAutomatically = true)
//	@Query(value ="SELECT ingrediants.ingrediant_id, ammount, ingrediant FROM ingrediants"
//			+ " INNER JOIN recipe_ingrediants"
//			+ " ON recipe_ingrediants.ingrediant_id = ingrediants.ingrediant_id"
//			+ " WHERE recipe_ingrediants.recipe_id = ?1"
//			+ " ORDER BY ingrediants.ingrediant_id", nativeQuery = true)
//	Optional<List<Ingrediants>> getIngrediantsByRecipeId(int recipeId);

}
