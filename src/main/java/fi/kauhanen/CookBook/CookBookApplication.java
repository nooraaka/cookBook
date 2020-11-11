package fi.kauhanen.CookBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;

import fi.kauhanen.CookBook.domain.DishType;
import fi.kauhanen.CookBook.domain.DishTypeRepository;
import fi.kauhanen.CookBook.domain.Recipe;
import fi.kauhanen.CookBook.domain.RecipeRepository;
import fi.kauhanen.CookBook.domain.User;
import fi.kauhanen.CookBook.domain.UserRepository;

@SpringBootApplication
public class CookBookApplication {
	private static final Logger log = LoggerFactory.getLogger(CookBookApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cookbookDemo(RecipeRepository recipeRepository, DishTypeRepository dishTypeRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of recipes");
			
			dishTypeRepository.save(new DishType("Keitto"));			
			dishTypeRepository.save(new DishType("Pata"));
			dishTypeRepository.save(new DishType("Jälkiruoka"));
			
			recipeRepository.save(new Recipe("Kalakeitto", "Kalaa, vettä, perunoita, porkkanaa", "Pilko ainekset, keitä kattilassa 30min", dishTypeRepository.findByDishTypeName("Keitto").get(0)));
			recipeRepository.save(new Recipe("Makaronilaatikko", "Makaroni, jauheliha, kananmuna,  maito", "Ruskista jauheliha, kypsennä makaroni, tee munamaito ja uunissa 45min 200 astetta", dishTypeRepository.findByDishTypeName("Keitto").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
		log.info("fetch all recipes");
		for (Recipe recipe : recipeRepository.findAll()) {
			log.info(recipe.toString());
		}
		};
	}
}
