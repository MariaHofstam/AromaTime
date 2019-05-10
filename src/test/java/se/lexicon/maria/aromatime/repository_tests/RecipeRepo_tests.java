package se.lexicon.maria.aromatime.repository_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.entity.Recipe;
import se.lexicon.maria.aromatime.entity.RecipeContent;
import se.lexicon.maria.aromatime.repositories.RecipeContentRepo;
import se.lexicon.maria.aromatime.repositories.RecipeRepo;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class RecipeRepo_tests {

	@Autowired 
	private RecipeRepo testRepo;
	
	@Autowired 
	private RecipeContentRepo contentRepo;
	
	private int recipe1Id;
	private int recipe2Id;
	private Recipe recipe1;
	private Recipe recipe2;
	
	
	@Before
	public void init() {
		
		//Create some Oils
		Oil apelsin = new Oil("Apelsin");
		Oil timjan = new Oil("Timjan");	
		
		//Create some RecipeContents
		RecipeContent content1 = new RecipeContent(5, "dr", apelsin);
		
		RecipeContent content2 = new RecipeContent(7, "dr", timjan);
		RecipeContent content3 = new RecipeContent(2, "dr", apelsin);
		RecipeContent content4 = new RecipeContent(18, "dr", timjan);
		
		
		//Create and save some Recipes
		Recipe recipe1 = new Recipe();
		recipe1.addRecipeContent(content1);
		recipe1.addRecipeContent(content2);
		this.recipe1 = testRepo.save(recipe1);
		this.recipe1Id = this.recipe1.getId();
		
		Recipe recipe2 = new Recipe();
		recipe2.addRecipeContent(content3);
		recipe2.addRecipeContent(content4);
		this.recipe2 = testRepo.save(recipe2);
		this.recipe2Id = this.recipe2.getId();
		
	}
	
	@Test
	public void make_sure_recipe1_was_successfully_created() {
		int expectedNumOfContents = 2;
		
		Optional<Recipe> result = testRepo.findById(recipe1Id);
		assertTrue(result.isPresent());		
		Recipe testRecipe = result.get();
		
		assertEquals(testRecipe, this.recipe1);
		assertEquals(expectedNumOfContents, testRecipe.getContent().size());		
	}
	
	
}
