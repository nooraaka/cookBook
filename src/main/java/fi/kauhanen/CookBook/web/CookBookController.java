package fi.kauhanen.CookBook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.kauhanen.CookBook.domain.RecipeRepository;

@Controller
public class CookBookController {
	@Autowired
	private RecipeRepository repository;
	
	@RequestMapping("/helloUser")
	public String recipeList(Model model) {
		model.addAttribute("recipes", repository.findAll());
		return "helloUser";
		
	}

}
