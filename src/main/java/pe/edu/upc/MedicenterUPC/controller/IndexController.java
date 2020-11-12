package pe.edu.upc.MedicenterUPC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;

@Controller
@RequestMapping("/")
@SessionAttributes("{clinica,especialista}")
public class IndexController {
	@GetMapping
	public String index(Model model) {
		Clinica clinica= new Clinica();
		model.addAttribute("clinica",clinica);
		Especialista especialista = new Especialista();
		model.addAttribute("especialista", especialista);
		
		return "index";
	}
}
