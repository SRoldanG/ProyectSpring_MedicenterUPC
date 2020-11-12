package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	List<Paciente> findByNombresStartingWith(String nombres) throws Exception;

	Optional<Paciente> findByDni(String dni) throws Exception;
}
