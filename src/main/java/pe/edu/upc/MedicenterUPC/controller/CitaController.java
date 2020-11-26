package pe.edu.upc.MedicenterUPC.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import pe.edu.upc.MedicenterUPC.security.UsuarioDetails;
import pe.edu.upc.MedicenterUPC.services.CitaService;
import pe.edu.upc.MedicenterUPC.services.PacienteService;

@Controller
@RequestMapping("/citas")

@SessionAttributes("{clinica, doctor, detalleCita,perfil }")
@SessionAttributes("{clinica, doctor, detalleCita}")

public class CitaController {

	@Autowired
	private CitaService citaService;

	@Autowired
	private PacienteService pacienteService;


	@GetMapping("miscitas")
	public String miscitas(@ModelAttribute("clinica") Clinica clinica,
			@ModelAttribute("doctor") Especialista doctor, Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		try {
			Optional<Paciente> optional = pacienteService.findById(usuarioDetails.getIdSegmento());
			if (optional.isPresent()) {
				List<Cita> citasdeusuario= optional.get().getCitas();
				model.addAttribute("citas",citasdeusuario);
			}
		}
		catch(Exception e){
			e.printStackTrace();	
		}

		return "citas/miscitas";
	}
	
	@PostMapping("agregarcita")
	public String agregarcita(@ModelAttribute("clinica") Clinica clinica, @ModelAttribute("doctor") Especialista doctor,
			@ModelAttribute("detalleCita") Cita detalleCita, Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
			Optional<Paciente> paciente = pacienteService.findById(usuarioDetails.getIdSegmento());
			detalleCita.setPaciente(paciente.get());
			detalleCita.setDuracion("30 minutos");
			detalleCita.setPrecio((float) 70);
			citaService.save(detalleCita);
			model.addAttribute("citaResumen", detalleCita);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "citas/resumen";
	}
	

	@GetMapping("historialCita")
	public String allclinicas(@ModelAttribute("clinica") Clinica clinica, @ModelAttribute("doctor") Especialista doctor,
			@ModelAttribute("detallecita") Cita detalleCita,Model model) {
		try {
			List<Cita> lista= citaService.findAll();
			lista.remove(citaService.findById(1).get());
			model.addAttribute("historialCita", lista);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "citas/historialCita";
	@GetMapping("{idCita}/p")
	public String view(@PathVariable("idCita") Integer idCita,
			@ModelAttribute("doctor") Especialista doctor, @ModelAttribute("clinica") Clinica clinica,Model model) {
		try {
			Optional<Cita> optional = citaService.findById(idCita);
			
			if (optional.isPresent()) {
				model.addAttribute("citaResumen", optional.get());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "citas/resumen";

	}
	
	

}
