package se.lexicon.maria.aromatime.service_tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.entity.Recipe;
import se.lexicon.maria.aromatime.entity.RecipeContent;
import se.lexicon.maria.aromatime.repositories.RecipeRepo;
import se.lexicon.maria.aromatime.service.OilService;
import se.lexicon.maria.aromatime.service.RecipeService;
import se.lexicon.maria.aromatime.service.RecipeServiceImpl;


@RunWith(SpringRunner.class)
public class RecipeTest {
	
	@TestConfiguration
	static class RecipeTestConfig{
		@Bean
		public RecipeServiceImpl recipeService(RecipeRepo recipeRepo, OilService oilService) {
			return new RecipeServiceImpl(recipeRepo, oilService);
		}
	}
	
	@Autowired
	private RecipeService testService;
	
	@MockBean
	private OilService oilService;
	
	@MockBean
	private RecipeRepo recipeRepo;
	
	private Recipe testRecipe;
	
	@Before
	public void init() {
		Recipe recipe = new Recipe();
		recipe.addRecipeContent(new RecipeContent(3,"dr", new Oil("lavendel")));
		recipe.addRecipeContent(new RecipeContent(2, "dr", new Oil("kamomill")));
		testRecipe = recipe;		
	}
	

	@Test
	public void test_findRecipeById_return_testRecipe() {
		when(recipeRepo.findById(anyInt())).thenReturn(Optional.of(testRecipe));
		
		assertEquals(testRecipe, testService.findRecipeById(12));
	}
	
	
	//Fundera över fler tester att göra
}
