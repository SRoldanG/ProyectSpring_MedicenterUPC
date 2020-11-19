package pe.edu.upc.MedicenterUPC.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.models.entities.Usuario;
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;
import pe.edu.upc.MedicenterUPC.services.PacienteService;
import pe.edu.upc.MedicenterUPC.services.UsuarioService;
import pe.edu.upc.MedicenterUPC.utils.Segmento;

@Controller
@RequestMapping("/signup")
@SessionAttributes("usuario")
public class SignUpController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private EspecialistaService especialistaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private String password;
	
	@GetMapping
	public String start(Model model) {
		Usuario usuario = new Usuario();
		usuario.setEnable(true);
		
		model.addAttribute("usuario", usuario);
		return "/usuario/signup";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("usuario") Usuario usuario,@ModelAttribute("paciente") Paciente paciente, Model model, SessionStatus status) {
		try {
			pacienteService.save(paciente);
			Optional<Paciente> optional=pacienteService.findById(paciente.getId_paciente());
			if (optional.isPresent())
			{
				model.addAttribute("pacienteRegistrado",optional.get());
				usuario.setSegmento(Segmento.PACIENTE);
				usuario.setIdSegmento(optional.get().getId_paciente());
				usuario.addAuthority("ROLE_PATIENT");
				this.password = usuario.getPassword();
				usuario.setPassword( passwordEncoder.encode(this.password));
				usuarioService.save(usuario);
				status.setComplete();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/login";
	}
	
	@PostMapping("/saveEspecialist")
	public String saveEspecialist(@ModelAttribute("usuario") Usuario usuario,@ModelAttribute("especialista") Especialista especialista, Model model, SessionStatus status) {
		try {
			especialistaService.save(especialista);
			Optional<Especialista> optional=especialistaService.findById(especialista.getId_especialista());
			if (optional.isPresent())
			{
				model.addAttribute("especialistaRegistrado",optional.get());
				usuario.setSegmento(Segmento.ESPECIALISTA);
				usuario.setIdSegmento(optional.get().getId_especialista());
				usuario.addAuthority("ROLE_ESPECIALIST");
				this.password = usuario.getPassword();
				usuario.setPassword( passwordEncoder.encode(this.password));
				usuarioService.save(usuario);
				status.setComplete();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/login";
	}
}
