package fi.kauhanen.CookBook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Etusivu - Hae reseptejä nimellä - Lisää uusi resepti
	@RequestMapping(value={"/", "/helloUser"})
	public String helloUser(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "helloUser";
	}
	// Listaa reseptit
	@RequestMapping(value = {"/", "/list"})
	public String listRecipe(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "list";
	}

	// Lisää uusi resepti 
	@RequestMapping(value = "/add")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("dishTypes", dishTypeRepository.findAll());
		return "add";
	}
	//Tallenna uusi resepti
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Recipe recipe) {
		recipeRepository.save(recipe);
		return "redirect:list";
	}

	
//	 Delete recipe
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
   public String deleteRecipe(@PathVariable("id") Long recipeid, Model model) {
    	recipeRepository.deleteById(recipeid);
        return "redirect:../list";
    }     


    // Edit recipe
   	@RequestMapping(value = "/edit/{id}")
    public String addRecipe(@PathVariable("id") Long recipeid, Model model) {
    	model.addAttribute("recipe", recipeRepository.findById(recipeid));
//    	model.addAttribute("dishTypes", dishTypeRepository.findAll());
    	return "editrecipe";
    }  
}
