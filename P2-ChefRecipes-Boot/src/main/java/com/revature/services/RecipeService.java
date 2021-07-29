package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RecipeTransferDAO;
import com.revature.daos.RecipesDAOInterface;
import com.revature.daos.UserDAOInterface;
import com.revature.models.database.Recipes;
import com.revature.models.database.Users;
import com.revature.models.dtos.RecipeDTO;

@Service
public class RecipeService {
	
	private RecipesDAOInterface recipesDAO;
	private UserDAOInterface userDAO;
	private RecipeTransferDAO recTransferDAO;
	
	@Autowired
	public RecipeService(RecipesDAOInterface recipesDAO, UserDAOInterface userDAO, RecipeTransferDAO recTransferDAO) {
		super();
		this.recipesDAO = recipesDAO;
		this.userDAO = userDAO;
		this.recTransferDAO = recTransferDAO;
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

	public boolean insertRecipe(RecipeDTO recipeDTO, int id) {
		Users user = userDAO.findById(id).get();
		recipeDTO.setUserIdDTO(user.getUserId());
		if(recTransferDAO.save(recipeDTO.getNameDTO(), recipeDTO.getDescriptionDTO(), recipeDTO.getCategoryDTO(), recipeDTO.getInspirationDTO(), recipeDTO.getUserIdDTO()) != null) {
//			RecipeIngrediants recIng = new RecipeIngrediants();
//			RecipeSteps recStep = new RecipeSteps();
//			for(Ingrediants ingrediant : ingrediants) {
//				recipesDAO.save(ingrediant);
//				recIng.setIngrediant(ingrediant);
//				recIng.setRecipe(recipe);
//				ingrediant.getRecipeIngrediants().add(recIng);
//				recipe.getRecipeIngrediants().add(recIng);
//			}
//			for(Steps step : steps) {
//				recipesDAO.save(step);
//				recStep.setStep(step);
//				recStep.setRecipe(recipe);
//				step.getRecipeSteps().add(recStep);
//				step.getRecipeSteps().add(recStep);
//			}
			return true;
		}
		return false;
	}

//	public boolean insertIngrediants(List<Ingrediants> ingrediants, int id) {
//		//Users user = userDAO.findById(id).get();
//		//List<Recipes> recipeList = getUserRecipes(user.getUserId());
//		Recipes recipe = recipesDAO.getByRecipeId(id);
//		System.out.println(recipesDAO.getByRecipeId(id));
//		if(recipesDAO.save(ingrediants)) {
//			//RecipeIngrediants recIng = new RecipeIngrediants();
//			//RecipeSteps recStep = new RecipeSteps();
////			for(Ingrediants ingrediant : ingrediants) {
////				recipesDAO.save(ingrediant);
////				recIng.setIngrediant(ingrediant);
////				recIng.setRecipe(recipe);
////				ingrediant.getRecipeIngrediants().add(recIng);
////				recipe.getRecipeIngrediants().add(recIng);
////			}
////			for(Steps step : steps) {
////				recipesDAO.save(step);
////				recStep.setStep(step);
////				recStep.setRecipe(recipe);
////				step.getRecipeSteps().add(recStep);
////				step.getRecipeSteps().add(recStep);
////			}
//			return true;
//		}
//		return false;
//	}
	
	

}
