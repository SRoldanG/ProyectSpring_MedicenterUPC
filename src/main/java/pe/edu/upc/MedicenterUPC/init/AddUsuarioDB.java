package pe.edu.upc.MedicenterUPC.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.MedicenterUPC.models.entities.Usuario;
import pe.edu.upc.MedicenterUPC.repositories.UsuarioRepository;
import pe.edu.upc.MedicenterUPC.utils.Segmento;


@Service
public class AddUsuarioDB implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//		 
//		Usuario paciente1 = new Usuario();
//		paciente1.setUsername("paciente1");
//		paciente1.setPassword( bcpe.encode("paciente") );
//		paciente1.setEnable(true);
//		paciente1.setSegmento(Segmento.PACIENTE);
//		paciente1.setIdSegmento(1);
//		
//		Usuario paciente2 = new Usuario();
//		paciente2.setUsername("paciente2");
//		paciente2.setPassword( bcpe.encode("paciente") );
//		paciente2.setEnable(true);
//		paciente2.setSegmento(Segmento.PACIENTE);
//		paciente2.setIdSegmento(2);
//		
//		
//		Usuario especialista1 = new Usuario();
//		especialista1.setUsername("especialista1");
//		especialista1.setPassword( bcpe.encode("especialista") );
//		especialista1.setEnable(true);
//		especialista1.setSegmento(Segmento.ESPECIALISTA);
//		especialista1.setIdSegmento(1);
//		
//		Usuario especialista2 = new Usuario();
//		especialista2.setUsername("especialista2");
//		especialista2.setPassword( bcpe.encode("especialista") );
//		especialista2.setEnable(true);
//		especialista2.setSegmento(Segmento.ESPECIALISTA);
//		especialista2.setIdSegmento(2);
//		
//		Usuario especialista3 = new Usuario();
//		especialista3.setUsername("especialista3");
//		especialista3.setPassword( bcpe.encode("especialista") );
//		especialista3.setEnable(true);
//		especialista3.setSegmento(Segmento.ESPECIALISTA);
//		especialista3.setIdSegmento(3);
//		
//		// ROLE_CUSTOMER, ROLE_PROVIDER, ROLE_ADMIN
//		paciente1.addAuthority("ROLE_PATIENT");
//		paciente2.addAuthority("ROLE_PATIENT");
//		
//		especialista1.addAuthority("ROLE_ESPECIALIST");
//		especialista2.addAuthority("ROLE_ESPECIALIST");
//		especialista3.addAuthority("ROLE_ESPECIALIST");
//		
//		//ACCESS
//		paciente1.addAuthority("ACCESS_DESC");
//		paciente2.addAuthority("ACCESS_PROMO");
//		
//		usuarioRepository.save(paciente1);
//		usuarioRepository.save(paciente2);
////		
//		usuarioRepository.save(especialista1);
//		usuarioRepository.save(especialista2);
//		usuarioRepository.save(especialista3);
		
	}
	
}
