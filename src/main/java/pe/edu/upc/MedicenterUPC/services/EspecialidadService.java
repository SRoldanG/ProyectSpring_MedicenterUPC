package pe.edu.upc.MedicenterUPC.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Especialidad;
import pe.edu.upc.MedicenterUPC.utils.Segmento;

public interface EspecialidadService extends CrudService<Especialidad, Integer> {
	
List<Especialidad> findByNombres(String nombres) throws Exception;

//Optional<Especialidad> findById(Segmento segmento);
	
}
