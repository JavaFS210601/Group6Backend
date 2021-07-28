package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.database.Recipes;
import com.revature.models.database.Users;

@Repository
public interface RecipesDAOInterface extends JpaRepository<Recipes, Integer> {
	Optional<List<Recipes>> findByUserId(Users user);
}
