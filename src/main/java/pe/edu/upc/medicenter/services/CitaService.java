package pe.edu.upc.medicenter.services;

import java.util.Date;
import java.util.List;

import pe.edu.upc.medicenter.models.entities.Cita;

public interface CitaService extends CrudService<Cita,Integer>{
	List<Cita> findByPacientes(Integer idPaciente) throws Exception;
	List<Cita> findByEspecialista(Integer idEspecialista) throws Exception;
	List<Cita> findByFecha(Date fecha) throws Exception;
}
