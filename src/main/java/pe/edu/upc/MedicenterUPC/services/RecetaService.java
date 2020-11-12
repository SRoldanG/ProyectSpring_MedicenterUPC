package pe.edu.upc.MedicenterUPC.services;

import java.util.List;

import pe.edu.upc.MedicenterUPC.models.entities.Receta;

public interface RecetaService extends CrudService<Receta,Integer>{
	List<Receta> findByCita(Integer cita) throws Exception;
}
