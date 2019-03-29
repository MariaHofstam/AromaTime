package se.lexicon.maria.aromatime.repositories;

import org.springframework.data.repository.CrudRepository;

import se.lexicon.maria.aromatime.entity.Recipe;


public interface RecipeRepo extends CrudRepository<Recipe, Integer>{

}
