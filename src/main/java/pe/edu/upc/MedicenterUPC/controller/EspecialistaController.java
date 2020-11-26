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
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;

@Controller
@RequestMapping("/especialistas")
@SessionAttributes("{doctor,clinica,medico}")
public class EspecialistaController {

	@Autowired
	private EspecialistaService especialistaService;

	@PostMapping("search")
	public String search(@ModelAttribute("doctor") Especialista doctor, @ModelAttribute("clinica") Clinica clinica,
			Model model) {
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinica", clinica);

		try {
			List<Especialista> especialistas = especialistaService.findByNombres(doctor.getNombres());
			model.addAttribute("especialistas", especialistas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "especialistas/busquedaEspecialista";
	}

	@GetMapping("{nombres}-{id_especialista}/p")
	public String view(@ModelAttribute("doctor") Especialista doctor,
			@PathVariable("id_especialista") Integer id_especialista, @ModelAttribute("clinica") Clinica clinica,
			Model model) {
		model.addAttribute("doctor", doctor);
		try {
			Optional<Especialista> optional = especialistaService.findById(id_especialista);
			if (optional.isPresent()) {
				model.addAttribute("medico",optional);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "clinicas/vista";
	}
	
    @PostMapping("save")
    public String save (@ModelAttribute("especialistas") Especialista especialista )
    {     System.out.print(especialista.getApellidos());
          System.out.print(especialista.getNombres());
    	return "redirect:/";
    }
}
