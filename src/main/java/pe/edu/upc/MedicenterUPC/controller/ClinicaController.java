package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Cita;
import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.services.ClinicaService;


@Controller
@RequestMapping("/clinicas")
@SessionAttributes("{clinica, especialista, clinicaCita, detalleCita}")
public class ClinicaController {
	@Autowired
	private ClinicaService clinicaService;
	@PostMapping("search")
	public String search(@ModelAttribute("clinica") Clinica clinica,
			@ModelAttribute("especialista") Especialista especialista, Model model) {
		model.addAttribute("clinica", clinica);
		model.addAttribute("especialista",especialista);
		try {
			List<Clinica> clinicas = clinicaService.findByNombrec(clinica.getNombrec());
			model.addAttribute("clinicas", clinicas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "clinicas/result-search";
	}
	
	@GetMapping("{nombrec}-{idC}/p")
	public String view(@ModelAttribute("clinica") Clinica clinica, @PathVariable("idC") Integer idC, Model model) {
		model.addAttribute("clinica", clinica);
		try {
			Optional<Clinica> optional = clinicaService.findById(idC);
			
			if(optional.isPresent()) {
				model.addAttribute("clinicaCita", optional.get());
				Cita detalleCita = new Cita();
				detalleCita.setPrecio((float)70.00);
				detalleCita.setTipo_cita("Telemedicina");
				detalleCita.setDuracion("30 min");
				
				model.addAttribute("detalleCita", detalleCita);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "clinicas/vista";
	}
	
}
