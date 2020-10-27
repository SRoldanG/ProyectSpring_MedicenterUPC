package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Integer>{
	List<Cita> findByPacientes(Integer idPaciente) throws Exception;
	List<Cita> findByEspecialista(Integer idEspecialista) throws Exception;
}
