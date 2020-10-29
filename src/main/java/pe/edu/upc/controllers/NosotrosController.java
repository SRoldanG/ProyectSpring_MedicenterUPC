package pe.edu.upc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NosotrosController {
	
	@GetMapping("/Nosotros")
	public String getNosotros()
	{
		return "Nosotros.html";
	}
	

}
