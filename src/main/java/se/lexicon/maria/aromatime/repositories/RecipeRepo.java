package se.lexicon.maria.aromatime.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.entity.Recipe;


public interface RecipeRepo extends CrudRepository<Recipe, Integer>{
	List<Recipe> findByRecipeNameIgnoreCase(String name);
}
