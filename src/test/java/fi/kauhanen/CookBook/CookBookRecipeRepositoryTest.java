package fi.kauhanen.CookBook;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.kauhanen.CookBook.domain.Recipe;
import fi.kauhanen.CookBook.domain.RecipeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CookBookRecipeRepositoryTest {

	@Autowired RecipeRepository recipeRepository;
	
	@Test
	public void createNewRecipe() {
		Recipe recipe = new Recipe("Pannukakku", "Munia, jauhoja, vettä, sokeria", "Sekoita ainekset ja laita uuniin");
		recipeRepository.save(recipe);
		assertThat(recipe.getRecipeid()).isNotNull();
	}

}