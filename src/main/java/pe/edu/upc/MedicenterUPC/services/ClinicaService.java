package pe.edu.upc.MedicenterUPC.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;

public interface ClinicaService extends CrudService<Clinica, Integer>{
	List<Clinica> findByNombrec(String nombrec) throws Exception;
	List<Clinica> findByUbicacion(String ubicacion) throws Exception;
	Optional<Clinica> findById(Integer id) throws Exception;
}
