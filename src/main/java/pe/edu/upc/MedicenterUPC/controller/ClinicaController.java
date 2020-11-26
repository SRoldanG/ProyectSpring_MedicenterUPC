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
import pe.edu.upc.MedicenterUPC.models.entities.Distrito;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Usuario;
import pe.edu.upc.MedicenterUPC.repositories.UsuarioRepository;
import pe.edu.upc.MedicenterUPC.security.UsuarioDetailsService;
import pe.edu.upc.MedicenterUPC.services.ClinicaService;
import pe.edu.upc.MedicenterUPC.services.DistritoService;

@Controller
@RequestMapping("/clinicas")
@SessionAttributes("{clinica, doctor, clinicaCita, detalleCita }")
public class ClinicaController {
	@Autowired
	private ClinicaService clinicaService;
	@Autowired
	private DistritoService distritoService;

	@PostMapping("search")
	public String search(@ModelAttribute("clinica") Clinica clinica,
			@ModelAttribute("doctor") Especialista doctor, Model model) {
		model.addAttribute("clinica", clinica);
		try {
			List<Clinica> clinicas = clinicaService.findByNombrec(clinica.getNombrec());
			model.addAttribute("clinicas", clinicas);
			if (clinicas.isEmpty())
				return "clinicas/not-found";
			else
				return "clinicas/result-search";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("{nombrec}-{idC}/p")
	public String view(@ModelAttribute("clinica") Clinica clinica, @PathVariable("idC") Integer idC,
			@ModelAttribute("doctor") Especialista doctor, Model model) {
		model.addAttribute("clinica", clinica);
		
		try {
			Optional<Clinica> optional = clinicaService.findById(idC);
			
			if (optional.isPresent()) {
				model.addAttribute("clinicaCita", optional.get());
				List<Especialista> especialistas = optional.get().getEspecialistas();
				model.addAttribute("especialistas", especialistas);
				Cita detalleCita = new Cita();
				detalleCita.setDuracion("30 minutos");
				detalleCita.setPrecio((float) 70.00);
				model.addAttribute("detalleCita", detalleCita);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "clinicas/vista";
	}

	@GetMapping
	public String clinicas(@ModelAttribute("clinica") Clinica clinica,@ModelAttribute("distrito") Distrito distrito
			, @ModelAttribute("doctor") Especialista doctor,
			Model model) {
		
		model.addAttribute("distrito",distrito);
		try {
			model.addAttribute("distritos",distritoService.findAll());
			List<Clinica> lista = clinicaService.findAll();
			model.addAttribute("clinicauno",lista.get(0));
			lista.remove(lista.get(0));
			model.addAttribute("allClinicas", lista);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "clinicas/lista";
	}

	
	@PostMapping("pordistrito")
	public String pordistrito(@ModelAttribute("clinica") Clinica clinica,@ModelAttribute("distrito") Distrito distrito,
			@ModelAttribute("doctor") Especialista doctor, Model model) {
		model.addAttribute("distrito", distrito);
		try {
			model.addAttribute("distritos",distritoService.findAll());
			List<Clinica> lista = distritoService.findByNombre(distrito.getNombre()).get().getClinicas();
			if (!lista.isEmpty()) {
				model.addAttribute("clinicauno",lista.get(0));
				lista.remove(lista.get(0));
				model.addAttribute("allClinicas", lista);
				return "clinicas/lista";
			}
			else
				return "clinicas/not-found";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clinicas(clinica, distrito, doctor, model);
	}
	
}
