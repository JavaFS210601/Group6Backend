package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.revature.daos.IngrediantDAOInterface;
import com.revature.daos.RecipeIngrediantsDAOInterface;
import com.revature.daos.RecipeStepsDAOInterface;
import com.revature.daos.RecipeTransferDAO;
import com.revature.daos.RecipesDAOInterface;
import com.revature.daos.StepsDAOInterface;
import com.revature.daos.UserDAOInterface;
import com.revature.models.database.Ingrediants;
import com.revature.models.database.Recipes;
import com.revature.models.database.Steps;
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
	private RecipeStepsDAOInterface stepRecDAO;
	private StepsDAOInterface stepDAO;
	
	@Autowired
	public RecipeService(RecipesDAOInterface recipesDAO, UserDAOInterface userDAO, RecipeTransferDAO recTransferDAO,
			IngrediantDAOInterface ingDAO, RecipeIngrediantsDAOInterface ingRecDAO,  RecipeStepsDAOInterface stepRecDAO,  StepsDAOInterface stepDAO) {
		super();
		this.recipesDAO = recipesDAO;
		this.userDAO = userDAO;
		this.recTransferDAO = recTransferDAO;
		this.ingDAO = ingDAO;
		this.ingRecDAO = ingRecDAO;
		this.stepRecDAO = stepRecDAO;
		this.stepDAO = stepDAO;
	}
	
	public Recipes getRecipeById(int id) {
		
		return recipesDAO.findById(id).get();
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
			Ingrediants ing;
			try {
			//create ingrediants object using the separated ingrediant and amount
				 ing = new Ingrediants(ingrediantProperties[0], ingrediantProperties[1]);
			} catch (ArrayIndexOutOfBoundsException a) {
				 ing = new Ingrediants("", "");
			}
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
		
		//inserting steps
		recipeString = recipeDTO.getSteps();
		String[] stepList = recipeString.split("_");
		for(String item : stepList) {
			Steps step = new Steps(item);
			
			Steps savedStep = stepDAO.save(step);
			
			RecipeSteps recStep = new RecipeSteps();
			
			recStep.setStep_id(step);
			recStep.setRecipe_id(recipe);
			
			stepRecDAO.save(recStep);
		}
		
		
		
		if(insertedRec != null) {

			return true;
		}
		return false;
	}


	public boolean updateRecipe(RecipeDTO recipeDTO) {
		try {
			System.out.println(recipeDTO);
			recipesDAO.updateRecipes(recipeDTO.getCategory(), recipeDTO.getDescription(), 
					recipeDTO.getName(), recipeDTO.getRecipeId());
			List<RecipeIngrediants> recIngsList = ingRecDAO.findAll();
			
			String recipeString = recipeDTO.getIngrediants();
			
			String[] ingList = recipeString.split(",");
//			System.out.println(ingList[1]);
			
			ArrayList<Integer> ingrediantCount = new ArrayList<Integer>();
			
			int z = 0;
			for(RecipeIngrediants recIngs : recIngsList) {
				if(recIngs.getRecipe_id().getRecipe_id() == recipeDTO.getRecipeId()) {
					ingrediantCount.add(z+=1);
				}
			}
			
			ArrayList<String> ingrediantProperties = new ArrayList();
			int t = 0;
			for(String item : ingList) {
				String[] temp = item.split("-");
				ingrediantProperties.add(temp[t]);
				ingrediantProperties.add(temp[t+1]);

			}
			System.out.println(ingList.length);
			System.out.println(ingrediantCount.size());
			System.out.println(ingrediantProperties.size());
			
			int x = 0;
			for(RecipeIngrediants recIngs : recIngsList) {
				if(recIngs.getRecipe_id().getRecipe_id() == recipeDTO.getRecipeId()) {
					Ingrediants ing = recIngs.getIngrediant_id();
					System.out.println(ing);
					//System.out.println(ingrediantProperties + " " + ingrediantProperties[x+1]);
					ingDAO.updateIngrediants(ingrediantProperties.get(x), ingrediantProperties.get(x+1), ing.getIngrediant_id());
					x+=2;
				}
			}
			//
			if(ingList.length > ingrediantCount.size()) {
				for(int s = 0; s < (ingList.length - ingrediantCount.size())*2; s+=2) {
					Ingrediants ingrediant = new Ingrediants(ingrediantProperties.get(s+(ingrediantCount.size()*2)), ingrediantProperties.get(s+(ingrediantCount.size()*2)+1));
					
					Ingrediants savedIngrediant = ingDAO.save(ingrediant);
					
					RecipeIngrediants recIng = new RecipeIngrediants();
					
					Recipes recipe = recipesDAO.getById(recipeDTO.getRecipeId());
					
					recIng.setIngrediant_id(ingrediant);
					recIng.setRecipe_id(recipe);
					
					ingRecDAO.save(recIng);
				}
			}
			
			
			
			List<RecipeSteps> recStepsList = stepRecDAO.findAll();
			
			String stepsString = recipeDTO.getSteps();
			
			String[] stepList = stepsString.split("_");
			System.out.println(stepList[1]);
			
			ArrayList<Integer> stepsCount = new ArrayList<Integer>();
			
			int v = 0;
			for(RecipeSteps recSteps : recStepsList) {
				if(recSteps.getRecipe_id().getRecipe_id() == recipeDTO.getRecipeId()) {
					stepsCount.add(v+=1);
				}
			}
			
			int y = 0;
			for(RecipeSteps recSteps : recStepsList) {
				
				if(recSteps.getRecipe_id().getRecipe_id() == recipeDTO.getRecipeId()) {
					Steps step = recSteps.getStep_id();
					System.out.println(step);
					//System.out.println(ingrediantProperties + " " + ingrediantProperties[x+1]);
					stepDAO.updateSteps(stepList[y], step.getStep_id());
					y+=1;
				}
			}
			if(stepList.length > stepsCount.size()) {
				for(int s = 0; s < stepList.length - stepsCount.size(); s++) {
					Steps step = new Steps(stepList[s+stepsCount.size()]);
					
					Steps savedStep = stepDAO.save(step);
					
					RecipeSteps recStep = new RecipeSteps();
					
					Recipes recipe = recipesDAO.getById(recipeDTO.getRecipeId());
					
					recStep.setStep_id(step);
					recStep.setRecipe_id(recipe);
					
					stepRecDAO.save(recStep);
				}
			}
			
			
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
//		recipeDTO.getInspiration(),
//		stepDAO.updateSteps(recipeDTO);
		

}
	
	
	public List<RecipeIngrediants> getThridTable() {
		
		
		return ingRecDAO.findAll();
	}

	public List<RecipeSteps> getThridStepTable() {
		
		return stepRecDAO.findAll();

	}

	public List<Recipes> getRecipeByName(String name) {
		// TODO Auto-generated method stub
		
		Recipes recipe  = new Recipes();
		recipe.setName(name);
		
		
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
			      //.withMatcher("password", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		Example<Recipes> example = Example.of(recipe, customExampleMatcher);
		
		return recipesDAO.findAll(example);
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
