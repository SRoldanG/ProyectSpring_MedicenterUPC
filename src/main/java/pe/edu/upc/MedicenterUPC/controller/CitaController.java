package pe.edu.upc.MedicenterUPC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MedicenterUPC.models.entities.Cita;


@Controller
@RequestMapping("/citas")
@SessionAttributes("{clinica, detalleCita}")
public class CitaController {
	@PostMapping("agregarcita")
	public String agregarCita(@ModelAttribute("cita") Cita cita,
			Model model) {
		//System.out.println(detallePedido.getProducto().getDescripcion());
		//System.out.println(cita.g);
		//System.out.println(detallePedido.getProveedor().getNombre());
		return "redirect:/";
	}
}
