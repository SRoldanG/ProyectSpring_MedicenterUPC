package pe.edu.upc.MedicenterUPC.services;

import java.util.Date;
import java.util.List;

import pe.edu.upc.MedicenterUPC.models.entities.Cita;

public interface CitaService extends CrudService<Cita,Integer>{
	List<Cita> findByPacientes(Integer idpaciente) throws Exception;
	List<Cita> findByEspecialista(Integer idespecialista) throws Exception;
	List<Cita> findByFecha(Date fecha) throws Exception;
}
