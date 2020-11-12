package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;
import pe.edu.upc.medicenter.services.His_ClinicoService;

@Controller
@RequestMapping("/Historial")
public class HistorialController {
	@Autowired
	private His_ClinicoService his_ClinicoService;
    
	
	@PostMapping("search")
	public String search(@ModelAttribute("historial_clinico") Historial_Clinico historial_Clinico, Model model, Integer idCita) {
		model.addAttribute("historial_clinico", historial_Clinico);
		try {
			
			List<Historial_Clinico> historiales = his_ClinicoService.findByCita(idCita);
			model.addAttribute("historial_clinicos", historiales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Historial/buscar-historial";
	}
}
