package pe.edu.upc.MedicenterUPC.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Especialista;

public interface EspecialistaService extends CrudService<Especialista, Integer>{
	List<Especialista> findByNombres(String nombres) throws Exception;
	
}
