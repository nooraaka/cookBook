package fi.kauhanen.CookBook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.Bean;

import fi.kauhanen.CookBook.domain.Recipe;
import fi.kauhanen.CookBook.domain.RecipeRepository;

@SpringBootApplication
public class CookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository repository) {
		return (args) -> {
		Recipe r1 = new Recipe("Makaronilaatikko", "Pataruoka", "Makaronia", "grammaa", 500, 2);
		Recipe r2 = new Recipe("Kalakeitto", "Keitto", "Kalaa", "grammaa", 400, 1);
		
		repository.save(r1);
		repository.save(r2);
		};
	}
}
