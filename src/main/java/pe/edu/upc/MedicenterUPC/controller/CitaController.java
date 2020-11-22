 package pe.edu.upc.MedicenterUPC.controller;

import java.util.Date;
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
import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.models.entities.Usuario;
import pe.edu.upc.MedicenterUPC.services.CitaService;

@Controller
@RequestMapping("/citas")
@SessionAttributes("{clinica, doctor, detalleCita,perfil }")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@PostMapping("agregarcita")
	public String agregarcita(@ModelAttribute("clinica") Clinica clinica,
			@ModelAttribute("doctor") Especialista doctor,@ModelAttribute("detalleCita") Cita detalleCita,
			Model model) {
		try {
			Paciente paciente= new Paciente();
			paciente.setId_paciente(1);
			detalleCita.setPaciente(paciente);
			detalleCita.setDuracion("30 minutos");
			detalleCita.setPrecio((float)70);
			citaService.save(detalleCita);
			Optional<Cita> optional= citaService.findById(detalleCita.getIdCita());
			model.addAttribute("citaRegistrada",optional.get());
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "citas/resumen";
	}
	

	
}
