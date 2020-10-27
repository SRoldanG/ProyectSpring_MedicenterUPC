package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Receta;
@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {
	List<Receta> findByHistorial(Integer idH_Clinico) throws Exception;
}
