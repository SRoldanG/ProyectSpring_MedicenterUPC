package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.edu.upc.MedicenterUPC.models.entities.Especialista;


@Repository
public interface EspecialistaRepository extends JpaRepository<Especialista ,Integer>{
	List<Especialista> findByNombresContaining(String nombres) throws Exception;
	List<Especialista> findByDireccionContaining(String direccion) throws Exception;
}
