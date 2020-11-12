package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;

@Controller
@RequestMapping("/especialistas")
@SessionAttributes("{especialista,clinica}")
public class EspecialistaController {

	@Autowired
	private EspecialistaService especialistaService;

	@PostMapping("busca")
	public String busca(@ModelAttribute("especialista") Especialista especialista
			,@ModelAttribute("clinica") Clinica clinica, Model model) {

		model.addAttribute("especialista", especialista);
		model.addAttribute("especialista",especialista);
		try {
			List<Especialista> especialistas = especialistaService.findByNombres(especialista.getNombres());
			model.addAttribute("especialistas", especialistas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "especialistas/busqueda";
	}
}
