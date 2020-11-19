package pe.edu.upc.MedicenterUPC.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Paciente;

public interface PacienteService extends CrudService<Paciente,Integer>{
	List<Paciente> findByNombresStartingWith(String nombres) throws Exception;

	Optional<Paciente> findByDni(String dni) throws Exception;
}
