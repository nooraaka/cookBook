package fi.kauhanen.CookBook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CookBookController {

	@RequestMapping("/index")
	public String index() {
		return "Etusivu";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "Lisää uusi reseppti";
	}
	
	@RequestMapping("/list")
	public String list() {
		return "Katso reseptejä";
	}
}
