package fi.kauhanen.CookBook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	
	List<Recipe> findByRecipeName(String recipeName);
	
}
