package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer>{
	List<Especialidad> findByNombreStartingWith(String nombre) throws Exception;
}
