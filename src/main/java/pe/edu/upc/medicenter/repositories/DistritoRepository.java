package pe.edu.upc.medicenter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito,Integer>{
	Optional<Distrito> findByNombreContaining(String nombre) throws Exception;	
}
