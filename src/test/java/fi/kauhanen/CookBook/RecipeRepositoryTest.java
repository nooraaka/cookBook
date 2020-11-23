package fi.kauhanen.CookBook;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.kauhanen.CookBook.domain.DishType;
import fi.kauhanen.CookBook.domain.Recipe;
import fi.kauhanen.CookBook.domain.RecipeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Test
	public void findByRecipeName() {
		List<Recipe> recipes = recipeRepository.findByRecipeName("Kalakeitto");
		
		assertThat(recipes).hasSize(1);
	}
	@Test 
	public void createNewRecipe() {
		Recipe recipe = new Recipe("Kalakeitto", "Kalaa, vettä, perunoita, porkkanaa", "Pilko ainekset, keitä kattilassa 30min", new DishType("Keitto"));
		recipeRepository.save(recipe);
		assertThat(recipe.getRecipeid()).isNotNull();
		
	}
}
