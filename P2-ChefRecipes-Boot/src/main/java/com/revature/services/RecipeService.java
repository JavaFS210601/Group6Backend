package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RecipesDAO;
import com.revature.models.database.Recipes;

@Service
public class RecipeService {
	
	private RecipesDAO recipesDAO;
	
	@Autowired
	public RecipeService(RecipesDAO recipesDAO) {
		super();
		this.recipesDAO = recipesDAO;
	}

	public List<Recipes> getAllRecipes() {
		List<Recipes> recipes = recipesDAO.getAllRecipes();
		return recipes;
	}

	public List<Recipes> getUserRecipes(int id) {
		List<Recipes> userRecipes = recipesDAO.getUserResipes(id);
		return userRecipes;
	}
	
	

}
