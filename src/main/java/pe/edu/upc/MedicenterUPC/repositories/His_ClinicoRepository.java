package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;

@Service
public interface His_ClinicoRepository extends JpaRepository<Historial_Clinico,Integer>{
	List<Historial_Clinico> findByCita(Integer idCita) throws Exception;
	
}


