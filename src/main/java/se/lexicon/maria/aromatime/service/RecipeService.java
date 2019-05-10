package se.lexicon.maria.aromatime.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import se.lexicon.maria.aromatime.entity.Recipe;
import se.lexicon.maria.aromatime.entity.RecipeContent;


public interface RecipeService {

	Recipe findRecipeById(int id);
	
	List<Recipe> findByName(String name);

	List<Recipe> findAll();

	Recipe save(Recipe recipe);

	boolean removeRecipe(int id);	//needed?
	
	RecipeContent createRecipeContent(int oil_Id, int amount, String unit);

	Recipe createRecipe (List<RecipeContent> recipeContent);
	
	Recipe update(int recipeId, Recipe updated) throws EntityNotFoundException;

}
