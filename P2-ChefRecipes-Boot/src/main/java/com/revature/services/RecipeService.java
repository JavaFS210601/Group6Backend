package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RecipesDAOInterface;
import com.revature.daos.UserDAOInterface;
import com.revature.models.database.Recipes;
import com.revature.models.database.Users;

@Service
public class RecipeService {
	
	private RecipesDAOInterface recipesDAO;
	private UserDAOInterface userDAO;
	
	@Autowired
	public RecipeService(RecipesDAOInterface recipesDAO, UserDAOInterface userDAO) {
		super();
		this.recipesDAO = recipesDAO;
		this.userDAO = userDAO;
	}

	public List<Recipes> getAllRecipes() {
		List<Recipes> recipes = recipesDAO.findAll();
		return recipes;
	}

	

	public List<Recipes> getUserRecipes(int id) {
		
		Users user = userDAO.findById(id).get();
		Optional<List<Recipes>> userRecipes = recipesDAO.findByUserId(user);
		
		List<Recipes> recipeList = null;
		if(userRecipes.isPresent()) {
			recipeList = userRecipes.get();
			return recipeList;
		}
		return recipeList;
	}

}
