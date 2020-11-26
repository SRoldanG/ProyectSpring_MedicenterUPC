package pe.edu.upc.MedicenterUPC.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.security.UsuarioDetails;
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;
import pe.edu.upc.MedicenterUPC.services.PacienteService;
import pe.edu.upc.MedicenterUPC.utils.Segmento;



@Controller
@RequestMapping("/perfil")
@SessionAttributes("{clinica,doctor}")
public class PerfilController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private EspecialistaService especialistaService;
	
	@GetMapping
	public String perfil(@ModelAttribute("clinica") Clinica clinica,
			@ModelAttribute("doctor") Especialista doctor, Model model) {
		// Obtener el usuarioDetails para obtener los datos de CLiente o especialista
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails)authentication.getPrincipal();
		
		// Obtener los datos del CLiente o especialista 
		try {
			if(usuarioDetails.getSegmento() == Segmento.PACIENTE) {
				Optional<Paciente> optional = pacienteService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("segmento", "PACIENTE");
					model.addAttribute("paciente", optional.get());
				}
			} 
			else if(usuarioDetails.getSegmento() == Segmento.ESPECIALISTA) {
				Optional<Especialista> optional = especialistaService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("segmento", "ESPECIALISTA");
					model.addAttribute("especialista", optional.get());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "perfil/perfil";
	}
}
