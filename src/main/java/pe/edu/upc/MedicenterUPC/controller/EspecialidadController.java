package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Especialidad;
import pe.edu.upc.MedicenterUPC.services.EspecialidadService;

@Controller
@RequestMapping("/especialidad")
@SessionAttributes("{rama,clinica, doctor, clinicaCita, detalleCita }")
public class EspecialidadController {
	
	private EspecialidadService especialidadService;
	
	public String search (@ModelAttribute("rama") Especialidad rama, Model model )
	{
		model.addAttribute("rama", rama);
		
		try {
			
			List<Especialidad> especialidades= especialidadService.findByNombres(rama.getNombre());
			model.addAttribute("especialidades", especialidades);
			
		} catch (Exception e) {
			
		e.printStackTrace();
			// TODO: handle exception
		}
		
		return "especialidad/busquedaEspecialidad";
	}
	
	
	public String view (@ModelAttribute("rama") Especialidad rama, @PathVariable("Id_Especialidad") Integer Id_Especialidad, Model model)
	{
		model.addAttribute("rama", rama);
		
		try {
//			optional <Especialidad> optional = especialidadService.findById(Id_Especialidad));
			
			Optional<Especialidad> optional = especialidadService.findById(Id_Especialidad);
			if (optional.isPresent()) {
				model.addAttribute("rama", rama);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return "especialidad/";
	}
	
	
	
	

}
