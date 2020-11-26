package pe.edu.upc.MedicenterUPC.services;

import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer>{
	Optional<Distrito> findByNombre(String nombre) throws Exception;
}
