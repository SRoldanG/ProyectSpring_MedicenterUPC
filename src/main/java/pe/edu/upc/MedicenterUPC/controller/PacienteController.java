package pe.edu.upc.MedicenterUPC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;
import pe.edu.upc.MedicenterUPC.services.PacienteService;

@Controller
@RequestMapping("/pacientes/")
@SessionAttributes("{paciente,doctor,clinica,medico}")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialistaService especialistaService;
    
    @GetMapping("search")
    public String search(@ModelAttribute("paciente") Paciente paciente, Model model) {

        model.addAttribute("paciente", paciente);

        try {
            List<Paciente> pacientes = pacienteService.findByNombresStartingWith(paciente.getNombres());
            model.addAttribute("pacientes", pacientes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pacientes/buscarxpaciente";
        }
        
	
}