package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.IngrediantDAOInterface;
import com.revature.daos.RecipeIngrediantsDAOInterface;
import com.revature.daos.RecipeStepsDAOInterface;
import com.revature.daos.RecipeTransferDAO;
import com.revature.daos.RecipesDAOInterface;
import com.revature.daos.UserDAOInterface;
import com.revature.models.database.Ingrediants;
import com.revature.models.database.Recipes;
import com.revature.models.database.Users;
import com.revature.models.database.associations.RecipeIngrediants;
import com.revature.models.database.associations.RecipeSteps;
import com.revature.models.dtos.RecipeDTO;

@Service
public class RecipeService {
	
	private RecipesDAOInterface recipesDAO;
	private UserDAOInterface userDAO;
	private RecipeTransferDAO recTransferDAO;
	private IngrediantDAOInterface ingDAO;
	private RecipeIngrediantsDAOInterface ingRecDAO;
	private RecipeStepsDAOInterface ingRecStepDAO;
	
	@Autowired
	public RecipeService(RecipesDAOInterface recipesDAO, UserDAOInterface userDAO, 
			RecipeTransferDAO recTransferDAO, IngrediantDAOInterface ingDAO,
			RecipeIngrediantsDAOInterface ingRecDAO,  RecipeStepsDAOInterface ingRecStepDAO) {
		super();
		this.recipesDAO = recipesDAO;
		this.userDAO = userDAO;
		this.recTransferDAO = recTransferDAO;
		this.ingDAO = ingDAO;
		this.ingRecDAO = ingRecDAO;
		this.ingRecStepDAO = ingRecStepDAO;
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

	public boolean insertRecipe(RecipeDTO recipeDTO) {
		
		//get user object by id 
		//get userId from recipeDTO
		Users user = userDAO.findById(recipeDTO.getUserId()).get();
		
		//creating recipe object and assigning recipeDTO data to the created recipe
		Recipes recipe = new Recipes();
		recipe.setName(recipeDTO.getName());
		recipe.setDescription(recipeDTO.getDescription());
		recipe.setCategory(recipeDTO.getCategory());
		recipe.setInspiration(recipeDTO.getInspiration());
		
		//assigning user object to the created recipe object
		recipe.setUserId(user);

		//save recipe to database and return an entity of the inserted recipe
		//assign returned recipe to variable
		Recipes insertedRec = recipesDAO.save(recipe);
		
		//assning the ingrediants string to new variable
		String recipeString = recipeDTO.getIngrediants();
		
		//split ingrediant string on the , and create new array where each element is the separated strings
		String[] ingList = recipeString.split(",");
		
		//looping for multiple ingrediants
		for(String item : ingList) {
			//split item string on the - and create new array where each element is the separated strings
			String[] ingrediantProperties = item.split("-");
			
			//create ingrediants object using the separated ingrediant and amount
			Ingrediants ing = new Ingrediants(ingrediantProperties[0], ingrediantProperties[1]);
			
			//save ingrediants to the database and return an entity of the inserted ingrediantew
			Ingrediants ingrediant = ingDAO.save(ing);
			
			//create association table
			RecipeIngrediants recIng = new RecipeIngrediants();
			//assign recipe and ingrediants objects
			recIng.setIngrediant_id(ing);
			recIng.setRecipe_id(recipe);
			
			//add associated ingrediants and recipes to the lists in there appriate tables
//			ingrediant.getRecipeIngrediants().add(recIng);
//			recipe.getRecipeIngrediants().add(recIng);
			
			//save association table to the database
			ingRecDAO.save(recIng);
		}
		
		if(insertedRec != null) {
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

	public List<RecipeIngrediants> getThridTable() {
		
		
		return ingRecDAO.findAll();
	}

	public List<RecipeSteps> getThridStepTable() {
		
		return ingRecStepDAO.findAll();
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
