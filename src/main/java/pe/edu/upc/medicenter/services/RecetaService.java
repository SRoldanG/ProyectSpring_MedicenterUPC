package pe.edu.upc.medicenter.services;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Receta;

public interface RecetaService extends CrudService<Receta,Integer>{
	List<Receta> findByHistorial(Integer idH_Clinico) throws Exception;
	
}
