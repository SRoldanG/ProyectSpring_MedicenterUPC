package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica,Integer> {
	List<Clinica> findByNombrecContaining(String nombrec) throws Exception;
	List<Clinica> findByUbicacionContaining(String ubicacion) throws Exception;
	
}
