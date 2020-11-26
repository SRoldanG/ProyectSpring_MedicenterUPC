package pe.edu.upc.MedicenterUPC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialidad;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Usuario;

@Controller
@RequestMapping("/")
@SessionAttributes("{clinica, doctor,especialista,usuario}")
public class IndexController {
	@GetMapping
	public String index(Model model) {
		Clinica clinica= new Clinica();
		model.addAttribute("clinica",clinica);
		Especialista doctor = new Especialista();
		model.addAttribute("doctor", doctor);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
}
