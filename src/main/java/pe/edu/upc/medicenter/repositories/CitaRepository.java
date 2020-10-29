package pe.edu.upc.medicenter.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Integer>{
	List<Cita> findByPacientesContaining(Integer idPaciente) throws Exception;
	List<Cita> findByEspecialistaContaining(Integer idEspecialista) throws Exception;
	List<Cita> findByFechaContaining(Date fecha) throws Exception;
}
