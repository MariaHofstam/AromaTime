package se.lexicon.maria.aromatime;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.entity.Recipe;
import se.lexicon.maria.aromatime.entity.RecipeCategory;
import se.lexicon.maria.aromatime.entity.RecipeContent;
import se.lexicon.maria.aromatime.repositories.OilRepo;
import se.lexicon.maria.aromatime.repositories.RecipeRepo;



@Component
@Transactional(rollbackFor = Exception.class)
public class CommandLine implements CommandLineRunner{

	private OilRepo oilRepo;
	private RecipeRepo recipeRepo;
	
	@Autowired
	public CommandLine(OilRepo oilRepo, RecipeRepo recipeRepo) {
		this.oilRepo = oilRepo;
		this.recipeRepo = recipeRepo;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		//Create and save oils to database
		
		Oil lavendel = oilRepo.save(new Oil("Lavendel"));
		Oil kamomill = oilRepo.save(new Oil("Kamomill"));
		Oil teeTree = oilRepo.save(new Oil("Tee Tree"));
		Oil eukalyptos = oilRepo.save(new Oil("Eukalyptos"));
		Oil apelsin = oilRepo.save(new Oil("Apelsin"));
		Oil mandarin = oilRepo.save(new Oil("Mandarin"));
		Oil timjan = oilRepo.save(new Oil("Timjan"));
		Oil rosmarin = oilRepo.save(new Oil("Rosmarin"));
		Oil ylangYlang = oilRepo.save(new Oil("Ylang Ylang"));
		Oil cederträ = oilRepo.save(new Oil("Cederträ"));
		
		//Create recipe contents
		RecipeContent rc1 = new RecipeContent(3,"dr", lavendel);
		RecipeContent rc2 = new RecipeContent(2,"dr", kamomill);
		RecipeContent rc3 = new RecipeContent(1,"dr", mandarin);
		RecipeContent rc4 = new RecipeContent(2,"dr", cederträ);
		RecipeContent rc5 = new RecipeContent(3,"dr", timjan);
		RecipeContent rc6 = new RecipeContent(2,"dr", apelsin);
		RecipeContent rc7 = new RecipeContent(1,"dr", eukalyptos);
		RecipeContent rc8 = new RecipeContent(2,"dr", rosmarin);
		
		
		//Create recipe categories
		RecipeCategory category1 = new RecipeCategory();
		category1.setCategoryName("category1");
		RecipeCategory category2 = new RecipeCategory();
		category2.setCategoryName("category2");
		
		
		//Create recipe and add recipe-contents and recipe-category
		Recipe recipe1 = new Recipe();
		recipe1.setRecipeName("recipe1");
		recipe1.addRecipeContent(rc1);
		recipe1.addRecipeContent(rc2);
		recipe1.addCategory(category1);
		recipe1.setShortDescription("Short description for Recipe1");
		recipe1 = recipeRepo.save(recipe1);

		Recipe recipe2 = new Recipe();
		recipe2.setRecipeName("recipe2");
		recipe2.addRecipeContent(rc3);
		recipe2.addRecipeContent(rc4);
		recipe2.addCategory(category2);
		recipe2.setShortDescription("Short description for Recipe2");
		recipe2 = recipeRepo.save(recipe2);
		
		Recipe recipe3 = new Recipe();
		recipe3.setRecipeName("recipe3");
		recipe3.addRecipeContent(rc5);
		recipe3.addRecipeContent(rc6);
		recipe3.addCategory(category2);
		recipe3.setShortDescription("Short description for Recipe3");
		recipe3 = recipeRepo.save(recipe3);
		
		Recipe recipe4 = new Recipe();
		recipe4.setRecipeName("recipe4");
		recipe4.addRecipeContent(rc7);
		recipe4.addRecipeContent(rc8);
		recipe4.addCategory(category1);
		recipe4.setShortDescription("Short description for Recipe4");
		recipe4 = recipeRepo.save(recipe4);
		
	}

}
