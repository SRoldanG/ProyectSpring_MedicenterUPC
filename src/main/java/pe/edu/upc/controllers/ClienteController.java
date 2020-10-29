package pe.edu.upc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping
	public String inicio() 
	{
		return "clientes/inicio";
	}
	@GetMapping
	public String search()
	{
		return "clientes/search";
	}
	
}
