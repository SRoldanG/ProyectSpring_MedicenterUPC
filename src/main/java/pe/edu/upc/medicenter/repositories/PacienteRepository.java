package pe.edu.upc.medicenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer>{

}
