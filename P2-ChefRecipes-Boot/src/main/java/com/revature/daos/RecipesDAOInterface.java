package com.revature.daos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.database.Ingrediants;
import com.revature.models.database.Recipes;
import com.revature.models.database.Steps;
import com.revature.models.database.Users;
import com.revature.models.dtos.RecipeDTO;

@Repository
public interface RecipesDAOInterface extends JpaRepository<Recipes, Integer> {
	Optional<List<Recipes>> findByUserId(Users user);

}

