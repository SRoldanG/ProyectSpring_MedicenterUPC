package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.Receta;
@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {
	
}
