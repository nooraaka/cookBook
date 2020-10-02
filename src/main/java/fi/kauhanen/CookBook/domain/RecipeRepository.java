package fi.kauhanen.CookBook.domain;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	
}
