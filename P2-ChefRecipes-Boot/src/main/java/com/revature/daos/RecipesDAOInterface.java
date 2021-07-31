package com.revature.daos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.database.Recipes;
import com.revature.models.database.Users;

@Repository
public interface RecipesDAOInterface extends JpaRepository<Recipes, Integer> {
	
	Optional<List<Recipes>> findByUserId(Users user);
	
	@Transactional
	@Modifying
	@Query("Update Recipes SET category = ?1, description = ?2,"
			+ " name = ?3"
			+ " WHERE recipe_id = ?4")
	void updateRecipes(String category, 
			String description, 
			String name,
			int recipeId);
	
	// inspiration = :inspiration,

}

