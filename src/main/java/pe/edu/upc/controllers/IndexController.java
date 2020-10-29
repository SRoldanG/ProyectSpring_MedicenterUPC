package pe.edu.upc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	// GET y POST
	@GetMapping
	public String index(Model model) 
	{
		model.addAttribute("saludo", "Hello programmers");
		return "index";
	}

}
