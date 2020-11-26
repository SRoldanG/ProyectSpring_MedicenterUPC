package pe.edu.upc.MedicenterUPC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.services.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping("/Registro")
	public String registerpacient(Model model) {
		Paciente paciente = new Paciente();
		try {
			model.addAttribute("paciente", paciente);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "pacientes/registerPaciente";
	}	
	
	@PostMapping("save")
	public String save(@ModelAttribute("paciente") Paciente paciente) {
		try {
			pacienteService.save(paciente);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	@GetMapping("/perfil")
	public String profile()
	{
		return "pacientes/view";
	}
}
