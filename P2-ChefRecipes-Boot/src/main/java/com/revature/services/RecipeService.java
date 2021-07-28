package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RecipesDAOInterface;
import com.revature.models.database.Recipes;

@Service
public class RecipeService {
	
	private RecipesDAOInterface recipesDAO;
	
	@Autowired
	public RecipeService(RecipesDAOInterface recipesDAO) {
		super();
		this.recipesDAO = recipesDAO;
	}

	public List<Recipes> getAllRecipes() {
		List<Recipes> recipes = recipesDAO.findAll();
		return recipes;
	}

	

	public List<Recipes> getUserRecipes(int id) {
		Optional<List<Recipes>> userRecipes = recipesDAO.findById(id);
		
		List<Recipes> recipeList = null;
		if(userRecipes.isPresent()) {
			recipeList = userRecipes.get();
			return recipeList;
		}
		return recipeList;
	}

}
