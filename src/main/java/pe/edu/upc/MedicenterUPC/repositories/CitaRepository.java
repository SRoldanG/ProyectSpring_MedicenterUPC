package pe.edu.upc.MedicenterUPC.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Integer>{
	List<Cita> findByPacienteContaining(Integer paciente) throws Exception;
	List<Cita> findByEspecialistaContaining(Integer especialista) throws Exception;
	List<Cita> findByFechaContaining(Date fecha) throws Exception;
}
