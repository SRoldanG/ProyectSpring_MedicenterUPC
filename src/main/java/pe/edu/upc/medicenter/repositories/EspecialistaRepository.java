package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.medicenter.models.entities.Especialista;

 @Service
public interface EspecialistaRepository extends JpaRepository<Especialista ,Integer>{
	List<Especialista> findByEspecialidad(String especialidad) throws Exception;
	List<Especialista> findByClinica(Integer idClinica) throws Exception;
}
