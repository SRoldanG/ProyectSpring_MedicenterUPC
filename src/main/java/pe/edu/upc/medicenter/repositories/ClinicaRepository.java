package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica,Integer> {
	List<Clinica> findByNombreContaining(String nombres) throws Exception;
	List<Clinica> findByUbicacionContaining(String ubicacion) throws Exception;
	
}
