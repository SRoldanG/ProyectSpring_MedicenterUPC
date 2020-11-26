package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;
import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Medicamento;
import pe.edu.upc.MedicenterUPC.services.MedicamentosService;

@Controller
@RequestMapping("/medicamentos")
@SessionAttributes()
public class MedicamentoController {
	
	@Autowired
	private MedicamentosService medicamentosService;
	
	public String search(@ModelAttribute("medicamento")Medicamento medicamento,@ModelAttribute("especialista")Especialista especialista,@ModelAttribute("clinica") Clinica clinica, Model model) 
	{
		model.addAttribute("medicamento",medicamento);
		model.addAttribute("especialista",especialista);
        model.addAttribute("clinica",clinica);
        
        try
		{
			List<Medicamento> medicamentos = medicamentosService.findByNombre(medicamento.getNombre());
			model.addAttribute("medicamentos", medicamentos);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "medicamentos/busquedaMedicamento";
        
	}
}
