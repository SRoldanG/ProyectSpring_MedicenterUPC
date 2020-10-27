package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer>{
	List<Especialidad> findByNombreStartingWith(String nombre) throws Exception;
}
