package fi.kauhanen.CookBook.web;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.kauhanen.CookBook.domain.DishTypeRepository;
import fi.kauhanen.CookBook.domain.Recipe;
import fi.kauhanen.CookBook.domain.RecipeRepository;

@Controller
public class CookBookController {
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private DishTypeRepository dishTypeRepository;
	
	@Bean
	public Validator validator() {
	    return new LocalValidatorFactoryBean();
	}

	//login page
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}

	// Listaa reseptit
	@GetMapping(value = {"/", "/list"})
	public String recipeList(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "list";
	}

	// Lisää uusi resepti 
	@GetMapping(value = "/add")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("dishTypes", dishTypeRepository.findAll());
		return "add";
	}
	
	//Tallenna uusi resepti

	@PostMapping(value = "/save")
	public String saveRecipe(@Valid Recipe recipe, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("dishTypes", dishTypeRepository.findAll());
			return "add";
		}
		recipeRepository.save(recipe);
		return "redirect:list";
	}
	
	
//	 Delete recipe
   @GetMapping(value = "/delete/{id}")
   public String deleteRecipe(@PathVariable("id") Long recipeid, Model model) {
    	recipeRepository.deleteById(recipeid);
        return "redirect:../list";
    }     


    // Edit recipe
   	@GetMapping(value = "/edit/{id}")
    public String editRecipe(@PathVariable("id") Long recipeid, Model model) {
    	model.addAttribute("recipe", recipeRepository.findById(recipeid));
    	model.addAttribute("dishTypes", dishTypeRepository.findAll());
    	return "editrecipe";
    }  
}
