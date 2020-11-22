package pe.edu.upc.MedicenterUPC.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.utils.Segmento;

public interface EspecialistaService extends CrudService<Especialista, Integer>{
	List<Especialista> findByNombres(String nombres) throws Exception;

//	Optional<Especialista> findById(Segmento segmento);

	
}
