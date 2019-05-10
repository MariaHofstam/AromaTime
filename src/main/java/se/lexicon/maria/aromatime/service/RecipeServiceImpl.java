package se.lexicon.maria.aromatime.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.entity.Recipe;
import se.lexicon.maria.aromatime.entity.RecipeContent;
import se.lexicon.maria.aromatime.repositories.RecipeRepo;



@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

	private RecipeRepo recipeRepo;
	private OilService oilService;

	@Autowired
	public RecipeServiceImpl(RecipeRepo recipeRepo, OilService oilService) {
		this.recipeRepo = recipeRepo;
		this.oilService = oilService;
	}


	@Override
	public Recipe findRecipeById(int id) {
		return recipeRepo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public List<Recipe> findByName(String name) {
		return recipeRepo.findByRecipeNameIgnoreCase(name);
	}
	
	@Override
	public List<Recipe> findAll() {
		return (List<Recipe>) recipeRepo.findAll();
	}


	@Override
	public Recipe save(Recipe recipe) {
		return recipeRepo.save(recipe);
	}
	
	@Override
	public boolean removeRecipe(int id) {		//needed?
			recipeRepo.deleteById(id);		
			return recipeRepo.existsById(id);
	}


	@Override
	public RecipeContent createRecipeContent(int oil_Id, int amount, String unit) {
		Oil oil = oilService.findById(oil_Id);
		return new RecipeContent(amount, unit, oil);		
	}


	@Override
	public Recipe createRecipe(List<RecipeContent> recipeContent) {
		Recipe newRecipe = new Recipe();
		
		for(RecipeContent cont : recipeContent) {
			newRecipe.addRecipeContent(cont);
		}
		
		return recipeRepo.save(newRecipe);
	}

	
	/**
	 * @param recipeId 
	 * @param updated
	 * @return Recipe original updated 
	 * @throws EntityNotFoundException when original recipe could not be found with recipeId
	 */
	
	@Override
	public Recipe update(int recipeId, Recipe updated) throws EntityNotFoundException{
		Recipe original = findRecipeById(recipeId);		
		original.setRecipeName(updated.getRecipeName());
		return recipeRepo.save(original);
	}
}
